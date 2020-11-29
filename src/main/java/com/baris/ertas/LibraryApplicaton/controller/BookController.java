package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.User;
import com.baris.ertas.LibraryApplicaton.repository.AuthorRepository;
import com.baris.ertas.LibraryApplicaton.repository.BookRepository;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import com.baris.ertas.LibraryApplicaton.service.BookService;
import javassist.NotFoundException;
import org.apache.coyote.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    private PublisherRepository publisherRepository;

    public static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    //get all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.findAllBooks();
    }
    //get book by id
    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable (value = "id") Long bookId) throws NotFoundException {
        return this.bookService.getBookById(bookId).orElseThrow(() -> new NotFoundException("Book not found with id " + bookId));
    }

    @PostMapping("/books")
    public Book createBook(Book book) {
        logger.info(book.toString());
        return bookService.save(book);
    }

//<td><a href="" th:href="@{api/books/delete/{id}(id=${book.id})}">Delete</a></td>
    //@DeleteMapping("/books/delete/{id}")
    @RequestMapping(path = "/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);
    }


   // @DeleteMapping("/{id}")
    //public Book
    //create user

    //update user
    /*@PutMapping("/{id}")
    public Book updateUser(@RequestBody Book book, @PathVariable (value = "id") long bookId ) throws NotFoundException {
        Book existingBook = this.bookService.getBookById(bookId).orElseThrow(() -> new NotFoundException("Book not found with id " + bookId));
        existingBook.setBookDescription(book.getBookDescription());
        existingBook.setBookOfPublisher(book.getBookOfPublisher());
        existingBook.setSeriesName(book.getSeriesName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setBookSubtitle(book.getBookSubtitle());
        return this.bookService.;
    }*/
    //delete book by id

}
