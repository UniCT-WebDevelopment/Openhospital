package com.openhospital.ecommerce.services;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.GetProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.GetProposalsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.get.OutputProposal;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.LockProposalsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.LockProposalsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.proposal.lock.OutputReservation;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.reservation.buy.BuyReservationsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsOutput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.Ward;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;

@Log4j2
@Component
public class CartServiceSharedBehaviours {

    @Autowired
    ProductService productService;

    public ArrayList<OutputProposal> getProposalsAndAddToModel(GetProposalsInput reqBody, String lang, ModelAndView model) throws IOException {
        GetProposalsOutput proposalOutput;
        log.debug(reqBody.toString());

        proposalOutput = productService.getProposals(reqBody);

        Result result = proposalOutput.getResult();
        ArrayList<OutputProposal> proposals = null;

        if (result != null && result.getValidResponse()) {
            log.error("Product-Service Response is valid");
            proposals = (ArrayList<OutputProposal>) proposalOutput.getProposals();
            model.addObject("proposals", proposals);
        } else {
            log.error("Product-Service Response is not valid. Setting an error message to be shown.");
            if (result != null)
                model.addObject("errorMessage", "errorCodeMsg." + result.getCode());
            else
                model.addObject("errorMessage", "errorCodeMsg.001");
        }

        return proposals;
    }

    public ArrayList<OutputReservation> lockProposalsAndAddToModel(LockProposalsInput reqBody, String lang, ModelAndView model) throws IOException {
        LockProposalsOutput lockProposalsOutput;
        log.debug(reqBody.toString());

        lockProposalsOutput = productService.lockProposals(reqBody);

        Result result = lockProposalsOutput.getResult();
        ArrayList<OutputReservation> reservations = null;

        if (result != null && result.getValidResponse()) {
            log.error("Product-Service Response is valid");
            reservations = (ArrayList<OutputReservation>) lockProposalsOutput.getReservations();
            model.addObject("reservations", reservations);
        } else {
            log.error("Product-Service Response is not valid. Setting an error message to be shown.");
            if (result != null)
                model.addObject("errorMessage", "errorCodeMsg." + result.getCode());
            else
                model.addObject("errorMessage", "errorCodeMsg.001");
        }

        return reservations;
    }

    public BuyReservationsOutput buyReservationsAndAddToModel(BuyReservationsInput reqBody, String lang, ModelAndView model) throws IOException {
        BuyReservationsOutput buyReservationsOutput;
        log.debug(reqBody.toString());

        buyReservationsOutput = productService.buyReservations(reqBody);

        Result result = buyReservationsOutput.getResult();

        if (result != null && result.getValidResponse()) {
            log.error("Product-Service Response is valid");
        } else {
            log.error("Product-Service Response is not valid. Setting an error message to be shown.");
            if (result != null)
                model.addObject("errorMessage", "errorCodeMsg." + result.getCode());
            else
                model.addObject("errorMessage", "errorCodeMsg.001");
        }

        return buyReservationsOutput;
    }


    public ArrayList<Ward> getWardsAndAddToModel(String lang, ModelAndView model) throws IOException {
        GetWardsInput getWardsInput = new GetWardsInput();
        getWardsInput.setLang(lang);
        log.info("getWardsInput:" + getWardsInput);

        GetWardsOutput wardsOutput = productService.getWards(getWardsInput);

        Result result = wardsOutput.getResult();
        ArrayList<Ward> wards = null;

        if (result != null && result.getValidResponse()) {
            log.error("Product-Service Response is valid");
            wards = (ArrayList<Ward>) wardsOutput.getWards();
            model.addObject("wards", wards);
        } else {
            log.error("Product-Service Response is not valid. Setting an error message to be shown.");
            if (result != null)
                model.addObject("errorMessage", "errorCodeMsg." + result.getCode());
            else
                model.addObject("errorMessage", "errorCodeMsg.001");
        }

        return wards;
    }

}
