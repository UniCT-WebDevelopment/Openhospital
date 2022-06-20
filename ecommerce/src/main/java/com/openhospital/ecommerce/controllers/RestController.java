package com.openhospital.ecommerce.controllers;

import com.openhospital.ecommerce.beans.externalservices.productservice.Result;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsInput;
import com.openhospital.ecommerce.beans.externalservices.productservice.ward.GetWardsOutput;
import com.openhospital.ecommerce.beans.externalservices.userservice.add.AddUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.add.AddUserOutput;
import com.openhospital.ecommerce.beans.externalservices.userservice.edit.EditUserInput;
import com.openhospital.ecommerce.beans.externalservices.userservice.edit.EditUserOutput;
import com.openhospital.ecommerce.beans.externalservices.userservice.get.GetUserInput;
import com.openhospital.ecommerce.beans.requestbody.SearchResultsInput;
import com.openhospital.ecommerce.beans.user.UserProfile;
import com.openhospital.ecommerce.constants.UserType;
import com.openhospital.ecommerce.security.UserDetailsServiceImpl;
import com.openhospital.ecommerce.services.ProductService;
import com.openhospital.ecommerce.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@org.springframework.web.bind.annotation.RestController
@ControllerAdvice
@RequestMapping(value = "/rest")
public class RestController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping(value = {"/{lang}/getWards"})
    public GetWardsOutput getWards(
            @PathVariable(value = "lang") String lang,
            HttpServletRequest request, HttpServletResponse response) throws IOException {

        log.info(">>> START controller: getWards");
        GetWardsInput getWardsInput = new GetWardsInput();
        getWardsInput.setLang(lang);
        log.info("getWardsInput:" + getWardsInput);

        GetWardsOutput wardsOutput = productService.getWards(getWardsInput);

        log.info("<<< END controller: getWards");

        return wardsOutput;
    }

    @PostMapping({"/auth/register"})
    public ModelAndView register(
            @ModelAttribute AddUserInput reqBody,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: register");
        reqBody.setUserType(UserType.USER.name());
        AddUserOutput addUserOutput = userService.addUser(reqBody);

        log.info("addUserOutput:" + addUserOutput);

        log.info("<<< END controller: register");

        ModelAndView model = new ModelAndView("redirect:/it/index");
        //model.addObject("requestPath", "/" + lang + "/" + model.getViewName());
        return model;
    }

    @PostMapping({"/auth/update"})
    public ModelAndView update(
            @ModelAttribute EditUserInput reqBody,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info(">>> START controller: register");
        UserProfile user = (UserProfile) request.getSession().getAttribute("user");
        reqBody.setUserId(user.getId());
        EditUserOutput editUserOutput = userService.editUser(reqBody);
        log.info("editUserOutput:" + editUserOutput);

        if (editUserOutput.getResult() != null && editUserOutput.getResult().getValidResponse()) {
            user = (UserProfile) userDetailsServiceImpl.loadUserByUsername(reqBody.getEmail());
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession().setAttribute("user", user);
        }

        log.info("<<< END controller: register");

        ModelAndView model = new ModelAndView("redirect:/it/user-area/my-data");
        //model.addObject("requestPath", "/" + lang + "/" + model.getViewName());
        return model;
    }
}
