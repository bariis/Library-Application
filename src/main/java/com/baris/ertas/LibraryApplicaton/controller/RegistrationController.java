package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.LibraryApplicatonApplication;
import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import com.baris.ertas.LibraryApplicaton.service.PublisherService;
import com.baris.ertas.LibraryApplicaton.service.UserService;
import com.baris.ertas.LibraryApplicaton.util.RedirectHome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    RedirectHome redirectHome = new RedirectHome();
    @Autowired
    private UserService userService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookService bookService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        redirectHome.addModelsandLoggedInUser(model);
        List<Book> bookList = bookService.findAllBooks();
        List<Author> authorList = authorService.findAllAuthors();
        List<Publisher> publisherList = publisherService.findAllPublishers();

        model.addAttribute("books", bookList);
        model.addAttribute("authors", authorList);
        model.addAttribute("publishers", publisherList);

        return "home";
    }
}
