package com.openhospital.ecommerce.controllers;

import com.openhospital.ecommerce.beans.cart.Cart;
import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.OutputProposal;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.OutputReservation;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsOutput;
import com.openhospital.ecommerce.beans.requestbody.AddToCartInput;
import com.openhospital.ecommerce.beans.requestbody.DeleteFromCartInput;
import com.openhospital.ecommerce.beans.requestbody.PayInput;
import com.openhospital.ecommerce.beans.requestbody.SearchResultsInput;
import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.constants.OrderStatus;
import com.openhospital.ecommerce.constants.PaymentMethod;
import com.openhospital.ecommerce.entities.Purchase;
import com.openhospital.ecommerce.services.CartService;
import com.openhospital.ecommerce.services.EcommerceService;
import com.openhospital.ecommerce.services.UtilsService;
import com.openhospital.ecommerce.services.ModelUtilsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Log4j2
@Controller
@ControllerAdvice
@PropertySource("${environment.properties}")
public class CartController {

    @Autowired
    ModelUtilsService modelUtils;

    @Autowired
    CartService cartService;

    @Autowired
    UtilsService utilsService;

    @Autowired
    EcommerceService ecommerceService;

    //@GetMapping({"/{lang}/search/product"})
    public ModelAndView searchLoadingController(
            @PathVariable(value = "lang") String lang,
            HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute SearchResultsInput inputForm) throws IOException, SQLException {

        //This endpoint is only used for showing a loading page while the user searches for a product.
        //After a short period the view redirects the request towards the /{lang}/search/{productType} endpoint

        log.info(">>> START controller: searchLoadingController");

        ModelAndView model = new ModelAndView("search-results-loading");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
        cartService.searchWardsAndAddToModel(lang, model);

        model.addObject("lang", lang);
        model.addObject("queryString", request.getQueryString());
        model.addObject("requestBody", inputForm);

        log.info("<<< END controller: searchLoadingController");

        return model;
    }

    @GetMapping({"/{lang}/search/{productType}"})
    public ModelAndView searchProducts(
            @ModelAttribute SearchResultsInput reqBody,
            @PathVariable(value = "lang") String lang,
            @PathVariable(value = "productType") String productType,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            @SessionAttribute(name = "proposals", required = false) ArrayList<OutputProposal> sessionProposals,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: searchProducts");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("search-results");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, "search/" + productType);
        utilsService.addRequestPathToModel(request, lang, model, "search/" + productType);
        cartService.searchProductsAndAddObjectsToModel(reqBody, lang, cart, sessionProposals, model, request);
        cartService.searchWardsAndAddToModel(lang, model);

        model.addObject("lang", lang);
        model.addObject("widgetActiveTab", reqBody.getProductType().toLowerCase());
        model.addObject("editWidget", true);

        log.info("<<< END controller: searchProducts");

        return model;
    }

    @GetMapping({"/{lang}/cart"})
    public ModelAndView cart(
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            @SessionAttribute(name = "proposals", required = false) ArrayList<OutputProposal> sessionProposals,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: cart");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("cart");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        model.addObject("cart", cart);
        model.addObject("lang", lang);

        log.info("<<< END controller: cart");

        return model;
    }

    @PostMapping({"/{lang}/add-to-cart"})
    public ModelAndView addToCart(
            @ModelAttribute AddToCartInput reqBody,
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            @SessionAttribute(name = "proposals", required = false) ArrayList<OutputProposal> sessionProposals,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: addToCart");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("redirect:/{lang}/cart");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, "cart");
        utilsService.addRequestPathToModel(request, lang, model, "cart");
        cart = cartService.addProductToCart(cart, sessionProposals, request, reqBody);

        model.addObject("cart", cart);
        model.addObject("lang", lang);

        log.info("<<< END controller: addToCart");

        return model;
    }

    @PostMapping({"/{lang}/delete-from-cart"})
    public ModelAndView deleteFromCart(
            @ModelAttribute DeleteFromCartInput reqBody,
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: deleteFromCart");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("redirect:/{lang}/cart");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, "cart");
        utilsService.addRequestPathToModel(request, lang, model, "cart");
        cart = cartService.deleteProductFromCart(cart, request, reqBody);

        model.addObject("cart", cart);
        model.addObject("lang", lang);

        log.info("<<< END controller: deleteFromCart");

        return model;
    }

    @GetMapping({"/{lang}/checkout"})
    public ModelAndView checkout(
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: checkout");

        ModelAndView model = new ModelAndView("checkout");
        model.addObject("modelUtils", modelUtils);

        if (cart == null || cart.getTotalElements() == 0) {
            model = new ModelAndView("redirect:/{lang}/cart");

        } else {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

            utilsService.addAlternateUrlsToModel(request, model, model.getViewName());
            utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
            model.addObject("cart", cart);
            model.addObject("lang", lang);
        }

        log.info("<<< END controller: checkout");

        return model;
    }

    @PostMapping({"/{lang}/pay"})
    public ModelAndView pay(
            @PathVariable(value = "lang") String lang,
            @ModelAttribute PayInput reqBody,
            @SessionAttribute(name = "user", required = true) UserProfile user,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: pay");

        ModelAndView model = new ModelAndView("redirect:/{lang}/complete-order");
        model.addObject("modelUtils", modelUtils);

        if (cart == null || cart.getTotalElements() == 0) {
            model = new ModelAndView("redirect:/{lang}/cart");

        } else {
            log.debug("reqBody: " + reqBody);

            if (reqBody.getPaymentMethod() == null || PaymentMethod.findByCode(reqBody.getPaymentMethod()) == null) {
                log.error("invalid paymentMethod: " + reqBody.getPaymentMethod() + ". user will be redirect to the error page");
                model = new ModelAndView("redirect:/{lang}/error");
            }

            log.debug("Creating purchase order...");
            Purchase purchaseOrder = ecommerceService.insertOrder(user, cart, reqBody);
            log.debug("Purchase order created with id " + purchaseOrder.getId());

            log.debug("Locking products inside order");
            cartService.lockProductsAndAddObjectsToModel(reqBody, lang, cart, user, model, request);

            ArrayList<OutputReservation> reservations = (ArrayList<OutputReservation>) request.getSession().getAttribute("reservations");

            if (reservations == null) {
                log.error("No reservations found. user will be redirect to the error page");
                model = new ModelAndView("redirect:/{lang}/error");
            } else {
                //Update cart (productCart needs to be updated to set reservationId)
                cartService.updateProductCartInSession(cart, reservations, request);
                log.debug("cart updated: " + cart);

                log.debug("Lock request ended successfully. Updating purchase order status...");
                //Update order (update status + add reservationId to products)
                ecommerceService.updateOrder(cart, purchaseOrder, OrderStatus.LOCKED);
                log.debug("Purchase order " + purchaseOrder.getId() + " status updated: " + OrderStatus.LOCKED.name());

                //Adding purchaseOrder to session
                request.getSession().setAttribute("purchaseOrder", purchaseOrder);
            }
        }

        log.info("<<< END controller: pay");

        return model;
    }

    @GetMapping({"/{lang}/complete-order"})
    public ModelAndView completeOrder(
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = true) Cart cart,
            @SessionAttribute(name = "purchaseOrder", required = true) Purchase purchaseOrder,
            @SessionAttribute(name = "reservations", required = false) ArrayList<OutputReservation> sessionReservations,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: completeOrder");
        Integer purchaseOrderId = purchaseOrder.getId();

        ModelAndView model = null;

        if (cart == null || cart.getTotalElements() == 0) {
            model = new ModelAndView("redirect:/{lang}/cart");

        } else {

            log.debug("Buying products inside order");
            BuyReservationsOutput buyReservationsOutput = cartService.buyProductsAndAddObjectsToModel(lang, cart, sessionReservations, model, request);
            Result result = buyReservationsOutput.getResult();

            if (result == null || !result.getValidResponse()) {
                log.error("Impossible to complete buy workflow. user will be redirect to the error page");
                model = new ModelAndView("redirect:/{lang}/error");
            } else {
                log.debug("Buy request ended successfully. Updating purchase order status...");

                //Update order (update status)
                ecommerceService.updateOrder(cart, purchaseOrder, OrderStatus.BOUGHT);
                log.debug("Purchase order " + purchaseOrderId + " status updated: " + OrderStatus.BOUGHT.name());

                String pnr = purchaseOrder.getPnr();

                model = new ModelAndView("redirect:/{lang}/thank-you/"+purchaseOrderId+"/"+pnr);
            }
        }

        log.info("<<< END controller: completeOrder");

        return model;
    }

}
