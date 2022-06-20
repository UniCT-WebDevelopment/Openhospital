package com.openhospital.ecommerce.services;

import com.openhospital.ecommerce.beans.cart.Cart;
import com.openhospital.ecommerce.beans.cart.ProductCart;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.GetProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.OutputProposal;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.InputProposal;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.LockProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.OutputReservation;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.InputReservation;
import com.openhospital.ecommerce.beans.requestbody.AddToCartInput;
import com.openhospital.ecommerce.beans.requestbody.DeleteFromCartInput;
import com.openhospital.ecommerce.beans.requestbody.PayInput;
import com.openhospital.ecommerce.beans.requestbody.SearchResultsInput;
import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.constants.ProductType;
import com.openhospital.ecommerce.utils.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class CartService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    CartServiceSharedBehaviours cartServiceSharedBehaviours;

    public void searchProductsAndAddObjectsToModel(SearchResultsInput reqBody, String lang, Cart cart,
                                                   ArrayList<OutputProposal> sessionProposals, ModelAndView model,
                                                   HttpServletRequest request) throws IOException, SQLException {

        GetProposalsInput getProposalsInput = new GetProposalsInput();
        getProposalsInput.setLang(reqBody.getLang());
        getProposalsInput.setProductType(reqBody.getProductType());
        getProposalsInput.setWardCode(reqBody.getWardCode());
        getProposalsInput.setDoctor(reqBody.getDoctor());
        getProposalsInput.setCheckIn(reqBody.getProductType().equalsIgnoreCase(ProductType.HEALTH.name()) ? DateUtils.getInstantFromString(reqBody.getCheckIn() + " " + reqBody.getCheckInTime()).toString() : null);

        ArrayList<OutputProposal> proposals = cartServiceSharedBehaviours.getProposalsAndAddToModel(getProposalsInput, lang, model);

        log.debug("Adding all proposal in session: " + proposals);
        if (sessionProposals != null) {
            if (proposals != null) {
                sessionProposals.addAll(proposals);
            } else {
                sessionProposals.clear();
            }
            request.getSession().setAttribute("proposals", sessionProposals);
        } else {
            request.getSession().setAttribute("proposals", proposals);
        }

        int totalResults = 0;
        if (proposals != null) {
            totalResults = proposals.size();
        }

        request.getSession().setAttribute("searchParams", reqBody);
        model.addObject("requestBody", reqBody);
        model.addObject("totalResults", totalResults);
    }

    public void searchWardsAndAddToModel(String lang, ModelAndView model) throws IOException, SQLException {
        cartServiceSharedBehaviours.getWardsAndAddToModel(lang, model);
    }


    public Cart addProductToCart(Cart cart,
                                 ArrayList<OutputProposal> sessionProposals,
                                 HttpServletRequest request, AddToCartInput reqBody) {

        log.info("Adding to cart from Search Page");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        String proposalId = reqBody.getProposalId();
        if (!"".equals(proposalId)) {
            for (OutputProposal proposal : sessionProposals) {
                log.info("proposal: " + proposal.getProposalId() + " - toAdd: " + proposalId);
                if (proposal.getProposalId().toString().equals(proposalId)) {
                    ProductCart product = new ProductCart();

                    product.setProductType(proposal.getProductType());
                    product.setProductCode(proposal.getProductCode());
                    product.setProductDescription(proposal.getProductDescription());
                    product.setProductProposalId(proposal.getProposalId());
                    product.setProductDescription(proposal.getProductDescription());
                    product.setCheckIn(Instant.parse(proposal.getCheckIn()));
                    product.setPrice(proposal.getPrice());
                    product.setMaxQuantity(proposal.getMaxQuantity());
                    product.setQuantity(1);

                    cart.getElements().add(product);
                    break;
                }
            }
        }

        return cart;
    }

    public Cart deleteProductFromCart(Cart cart, HttpServletRequest request, DeleteFromCartInput reqBody) {

        log.info("Delete from cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        String proposalId = reqBody.getProposalId();
        if (!"".equals(proposalId)) {
            ArrayList<ProductCart> finalElements = (ArrayList<ProductCart>) cart.getElements().clone();

            for (ProductCart product : cart.getElements()) {
                log.info("proposal: " + product.getProductProposalId() + " - toDelete: " + proposalId);
                if (product.getProductProposalId().toString().equals(proposalId)) {
                    finalElements.remove(product);
                }
            }

            cart.setElements(finalElements);
        }

        return cart;
    }

    public void clearCartFromSession(Cart cart, HttpServletRequest request) {
        if (cart != null) {
            cart = null;
            request.getSession().setAttribute("cart", cart);
        }
    }

    public void lockProductsAndAddObjectsToModel(PayInput reqBody, String lang, Cart cart,
                                                 UserProfile user, ModelAndView model,
                                                 HttpServletRequest request) throws IOException, SQLException {

        LockProposalsInput lockRequest = new LockProposalsInput();
        List<InputProposal> proposals = new ArrayList<>();

        for (ProductCart proposalsToLock : cart.getElements()) {
            InputProposal proposal = new InputProposal();
            proposal.setProposalId(proposalsToLock.getProductProposalId());
            proposal.setEmail(user.getEmail());
            proposal.setName(user.getName());
            proposal.setSurname(user.getSurname());
            proposals.add(proposal);
        }
        lockRequest.setProposals(proposals);

        ArrayList<OutputReservation> reservations = cartServiceSharedBehaviours.lockProposalsAndAddToModel(lockRequest, lang, model);

        log.debug("Adding all reservations in session: " + reservations);
        request.getSession().setAttribute("reservations", reservations);

        model.addObject("requestBody", reqBody);
    }

    public void updateProductCartInSession(Cart cart, ArrayList<OutputReservation> reservations, HttpServletRequest request) {
        if (cart != null) {
            for (OutputReservation outputReservation : reservations) {
                ArrayList<ProductCart> productCarts = (ArrayList<ProductCart>) cart.getElements().clone();
                for (ProductCart productCart : productCarts) {
                    if (outputReservation.getProposalId().equals(productCart.getProductProposalId())) {
                        log.debug("Updating proposal " + outputReservation.getProposalId() + "with reservationId " + outputReservation.getReservationId());
                        productCart.setReservationId(outputReservation.getReservationId());
                    }
                }
                cart.setElements(productCarts);
            }
            request.getSession().setAttribute("cart", cart);
        }
    }

    public BuyReservationsOutput buyProductsAndAddObjectsToModel(String lang, Cart cart,
                                                 ArrayList<OutputReservation> sessionReservations, ModelAndView model,
                                                 HttpServletRequest request) throws IOException, SQLException {
        if (sessionReservations != null) {
            BuyReservationsInput buyRequest = new BuyReservationsInput();
            List<InputReservation> reservations = new ArrayList<>();

            for (OutputReservation reservationToBuy : sessionReservations) {
                InputReservation reservation = new InputReservation();
                reservation.setReservationId(reservationToBuy.getReservationId());
                reservations.add(reservation);
            }
            buyRequest.setReservations(reservations);

            BuyReservationsOutput buyReservationsOutput = cartServiceSharedBehaviours.buyReservationsAndAddToModel(buyRequest, lang, model);

            log.debug("Clearing cart from session: " + cart);
            clearCartFromSession(cart, request);

            return buyReservationsOutput;
        }
        return null;
    }

}
