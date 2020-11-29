package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import com.baris.ertas.LibraryApplicaton.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    // tek bir kitabi gosterir
    @GetMapping( path = "books/show/{id}")
    public String showSingleBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> viewedBook = bookService.getBookById(id);
        if(viewedBook.isPresent()) {
            model.addAttribute("viewedBook", viewedBook);
            return "showBookDetails";
        }

        return "Boyle bir kitap yok sorun olustu.";
    }

    @GetMapping(path = "books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Optional<Book> viewedBook = bookService.getBookById(id);
        if(viewedBook.isPresent()) {
            System.out.println("view edilen book -> " + viewedBook.toString());
            List<Author> authorList = new ArrayList<>();
            List<Publisher> publisherList = new ArrayList<>();
            authorList = authorService.findAllAuthors();
            publisherList = publisherService.findAllPublishers();
            model.addAttribute("viewedBook", viewedBook);
            model.addAttribute("authors", authorList);
            model.addAttribute("publishers", publisherList);
            return "editBook";
        }

        return "Boyle bir kitap yok sorun olustu.";
    }


    //@PutMapping(path = "books/update/{id}")
    @RequestMapping(path = "books/edit/{id}", method = RequestMethod.POST)
    public String updateBook(@PathVariable("id") Long id, Book book) {
        bookService.updateBook(id, book);
        return "home";
    }


}
