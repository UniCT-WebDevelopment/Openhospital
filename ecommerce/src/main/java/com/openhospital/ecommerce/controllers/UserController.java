package com.openhospital.ecommerce.controllers;

import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.constants.ProductType;
import com.openhospital.ecommerce.entities.Purchase;
import com.openhospital.ecommerce.services.CartService;
import com.openhospital.ecommerce.services.EcommerceService;
import com.openhospital.ecommerce.services.UtilsService;
import com.openhospital.ecommerce.services.ModelUtilsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@Controller
@RequestMapping(value = "/{lang}/user-area")
public class UserController {

    @Autowired
    ModelUtilsService modelUtils;

    @Autowired
    CartService cartService;

    @Autowired
    UtilsService utilsService;

    @Autowired
    EcommerceService ecommerceService;

    @GetMapping({"/my-data"})
    public ModelAndView myData(
            @PathVariable(value = "lang") String lang,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException {

        log.info(">>> START controller: myData");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("my-data");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, "user-area/" + model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
        cartService.searchWardsAndAddToModel(lang, model);


        model.addObject("lang", lang);
        model.addObject("widgetActiveTab", ProductType.HEALTH.name().toLowerCase());

        log.info("<<< END controller: myData");

        return model;
    }

    @GetMapping({"/my-purchases"})
    public ModelAndView myPurchases(
            @PathVariable(value = "lang") String lang,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException, SQLException {

        log.info(">>> START controller: myPurchases");

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(lang));

        ModelAndView model = new ModelAndView("my-purchases");
        model.addObject("modelUtils", modelUtils);
        utilsService.addAlternateUrlsToModel(request, model, "user-area/" + model.getViewName());
        utilsService.addRequestPathToModel(request, lang, model, model.getViewName());
        cartService.searchWardsAndAddToModel(lang, model);

        UserProfile user = (UserProfile) request.getSession().getAttribute("user");
        List<Purchase> purchases = ecommerceService.getPurchaseFromUserId(user.getId());
        log.debug("purchases" + purchases);
        for (Purchase purchase : purchases) {
            log.debug("purchaseId" + purchase.getId());
            log.debug("purchase" + purchase);
        }

        model.addObject("purchases", purchases);
        model.addObject("lang", lang);
        model.addObject("widgetActiveTab", ProductType.HEALTH.name().toLowerCase());

        log.info("<<< END controller: myPurchases");

        return model;
    }
}
