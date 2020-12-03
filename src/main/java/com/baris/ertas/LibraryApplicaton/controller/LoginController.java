package com.baris.ertas.LibraryApplicaton.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }

        if (error != null)
            model.addAttribute("error", "Kullanici adi veya sifre yanlis.");

        if (logout != null)
            model.addAttribute("message", "Basarili bir sekilde cikis yaptiniz.");

        return "redirect:/home";
    }

    @GetMapping("/")
    public String default_url() {
        return "redirect:/home";
    }

}
