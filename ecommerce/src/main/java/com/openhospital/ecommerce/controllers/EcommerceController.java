package com.openhospital.ecommerce.controllers;

import com.openhospital.ecommerce.beans.cart.Cart;
import com.openhospital.ecommerce.constants.ProductType;
import com.openhospital.ecommerce.entities.Product;
import com.openhospital.ecommerce.entities.Purchase;
import com.openhospital.ecommerce.entities.Userdata;
import com.openhospital.ecommerce.services.CartService;
import com.openhospital.ecommerce.services.EcommerceService;
import com.openhospital.ecommerce.services.NewsService;
import com.openhospital.ecommerce.services.UtilsService;
import com.openhospital.ecommerce.services.ModelUtilsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
public class EcommerceController {

    @Autowired
    ModelUtilsService modelUtils;

    @Autowired
    CartService cartService;

    @Autowired
    NewsService newsService;

    @Autowired
    UtilsService utilsService;

    @Autowired
    EcommerceService ecommerceService;

    @GetMapping({"", "/{lang:it|en}", "/{lang:it|en}/"})
    public ModelAndView homeRedirect(
            @PathVariable(value = "lang") String lang,
            RedirectAttributes redirectAttributes) {

        log.info(">>> START controller: homeRedirect");
        ModelAndView model = new ModelAndView("redirect:/{lang}/index");
        return model;
    }

    @GetMapping({"/{lang}/index"})
    public ModelAndView home(
            @PathVariable(value = "lang") String lang,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException {

        log.info(">>> START controller: Homepage");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("index");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
        cartService.searchWardsAndAddToModel(lang, model);
        newsService.searchNewsAndAddToModel(lang, model);


        model.addObject("lang", lang);
        model.addObject("lightTheme", true);
        model.addObject("widgetActiveTab", ProductType.HEALTH.name().toLowerCase());

        log.info("<<< END controller: Homepage");

        return model;
    }

    @GetMapping({"/{lang}/error"})
    public ModelAndView error(
            @PathVariable(value = "lang") String lang,
            @SessionAttribute(name = "cart", required = false) Cart cart,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException {

        log.info(">>> START controller: error");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("error");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
        cartService.searchWardsAndAddToModel(lang, model);
        cartService.clearCartFromSession(cart, request);


        model.addObject("lang", lang);

        log.info("<<< END controller: error");

        return model;
    }

    @GetMapping({"/{lang}/thank-you/{purchaseOrderId}/{pnr}"})
    public ModelAndView thankYou(
            @PathVariable(value = "lang") String lang,
            @PathVariable(value = "purchaseOrderId") Integer purchaseOrderId,
            @PathVariable(value = "pnr") String pnr,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: thankYou");
        log.debug("purchaseOrderId " + purchaseOrderId);
        log.info("pnr " + pnr);

        ModelAndView model = new ModelAndView("thank-you");
        model.addObject("modelUtils", modelUtils);

        if (purchaseOrderId == null || pnr.isEmpty()) {
            model = new ModelAndView("redirect:/{lang}/error");

        } else {
            Optional<Purchase> optionalPurchase = ecommerceService.getPurchaseFromIdAndPnr(purchaseOrderId, pnr);

            if (optionalPurchase.isEmpty()) {
                model = new ModelAndView("redirect:/{lang}/error");
            } else {
                Purchase purchase = optionalPurchase.get();

                Userdata userdata = ecommerceService.getUserdataFromPurchase(purchase).get(0);
                List<Product> products = ecommerceService.getProductFromPurchase(purchase);

                LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
                localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

                String currentPage = model.getViewName() + "/" + purchaseOrderId + "/" + pnr;
                
                utilsService.addAlternateUrlsToModel(request, model, currentPage);
                utilsService.addRequestPathToModel(request, lang, model, currentPage);
                model.addObject("purchase", purchase);
                model.addObject("userdata", userdata);
                model.addObject("products", products);
                model.addObject("lang", lang);

            }
        }

        log.info("<<< END controller: thankYou");

        return model;
    }
}
