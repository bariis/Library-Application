package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import com.baris.ertas.LibraryApplicaton.service.PublisherService;
import com.baris.ertas.LibraryApplicaton.util.RedirectHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    RedirectHome redirectHome = new RedirectHome();

    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    // CALISIYOR
    @PostMapping("/books")
    public String createBook(Book book) {
        System.out.println("\n\n\n\n\n SU AN BURAYA GIRDI --------- \n\n\n\n\n ");
        bookService.save(book);
        //return "home";
        return "redirect:/home";
    }

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

    @PostMapping(path = "books/edit/{id}")
    public String updateBook(@PathVariable("id") Long id, Book book) {
        bookService.updateBook(id, book);

        return "redirect:/home";
    }

    @RequestMapping(path = "/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }

    @RequestMapping(path = "/filter")
    public String filteredBookList(Model model, @Param("keyword") String keyword) {
        redirectHome.addModelsandLoggedInUser(model);
        List<Author> authorList = authorService.findAllAuthors();
        List<Publisher> publisherList = publisherService.findAllPublishers();
        List<Book> bookList = bookService.listFilteredBooks(keyword);
        model.addAttribute("books", bookList);
        model.addAttribute("authors", authorList);
        model.addAttribute("publishers", publisherList);

        return "home";
    }
}


