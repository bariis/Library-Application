package com.baris.ertas.LibraryApplicaton.util;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import com.baris.ertas.LibraryApplicaton.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

public class RedirectHome {

    public void addModelsandLoggedInUser(Model model) {
        Book book = new Book();
        Author author = new Author();
        Publisher publisher = new Publisher();
        model.addAttribute("publisher", publisher);
        model.addAttribute("author", author);
        model.addAttribute("book", book);
    }

}
