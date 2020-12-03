package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/api")
public class BookControllerREST {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.findAllBooks();
    }

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable (value = "id") Long bookId) throws NotFoundException {
        return this.bookService.getBookById(bookId).orElseThrow(() -> new NotFoundException("Book not found with id " + bookId));
    }

    @RequestMapping(path = "/filter")
    public List<Book> filteredBookList(Model model, @Param("keyword") String keyword) {
        return bookService.listFilteredBooks(keyword);
    }
}
