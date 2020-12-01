package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    public String createAuthor(Author author) {
        authorService.save(author);
        return "redirect:/home";
    }
}
