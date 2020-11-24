package com.baris.ertas.LibraryApplicaton.component;

import com.baris.ertas.LibraryApplicaton.util.AuthenticationProvider;
import com.baris.ertas.LibraryApplicaton.model.CustomOAuth2User;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(OAuth2LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        super.onAuthenticationSuccess(request, response, authentication);

        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getEmail();
        User user = userService.findByEmail(email);
        String fullName = oAuth2User.getFullName();

        // giris yapilan email ile daha onceden kayit olunmadiysa kullaniciyi kaydeder.
        if(user == null) {
            userService.saveUserAfterOAuthLogin(email, fullName, AuthenticationProvider.FACEBOOK);
            //userService.saveUserAfterOAuthLogin(String email, String fullName, AuthenticationProvider.FACEBOOK);
        }

        logger.info(email);

    }

}
