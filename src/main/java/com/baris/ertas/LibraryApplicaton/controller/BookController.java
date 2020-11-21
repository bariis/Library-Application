package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String  getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "home";
    }

    @GetMapping("/{bookName}")
    public Book getBookByName(@PathVariable String bookName){
        Book book = bookService.getBookByName(bookName);

        return book;
    }

}
