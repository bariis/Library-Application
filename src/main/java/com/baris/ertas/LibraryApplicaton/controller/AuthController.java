package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.LibraryApplicatonApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    public static Logger logger = LoggerFactory.getLogger(AuthController.class);

    OAuth2AuthorizedClientService authClientService;

    @RequestMapping("/oauth2LoginSuccess")
    public String getOauth2LoginInfo(Model model,  OAuth2AuthenticationToken authenticationToken) {
        logger.info("su an methodun icine girdi.");
        // fetching the client details and user details
        System.out.println(authenticationToken.getAuthorizedClientRegistrationId()); // client name like facebook, google etc.
        System.out.println(authenticationToken.getName()); // facebook/google userId
        logger.info("client name -> " + authenticationToken.getAuthorizedClientRegistrationId());
        logger.info("userId -> " + authenticationToken.getName());
        //		1.Fetching User Info
        OAuth2User user = authenticationToken.getPrincipal(); // When you login with OAuth it gives you OAuth2User else UserDetails
        logger.info("userId: " + user.getName()); // returns the userId of facebook something like 12312312313212
        // getAttributes map Contains User details like name, email etc// print the whole map for more details
        logger.info("Email:" + user.getAttributes().get("email"));

        //2. Just in case if you want to obtain User's auth token value, refresh token, expiry date etc you can use below snippet
     //  OAuth2AuthorizedClient client = authClientService
       //         .loadAuthorizedClient(authenticationToken.getAuthorizedClientRegistrationId(),
         //               authenticationToken.getName());
        //logger.info("Token Value" + client.getAccessToken().getTokenValue());

        //3. Now you have full control on users data.You can eitehr see if user is not present in Database then store it and
        // send welcome email for the first time
        model.addAttribute("name", user.getAttribute("name"));
        return "home";

    }
}