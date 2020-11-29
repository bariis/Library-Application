package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // tek bir kitabi gosterir
    @GetMapping( path = "books/show/{id}")
    public String showSingleBook(@PathVariable("id") long id, Model model) {
        Optional<Book> viewedBook = bookService.getBookById(id);
        if(viewedBook.isPresent()) {
            model.addAttribute("viewedBook", viewedBook);
            return "showBookDetails";
        }

        return "Boyle bir kitap yok sorun olustu.";
    }

}
