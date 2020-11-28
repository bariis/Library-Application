package com.baris.ertas.LibraryApplicaton.service;


import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Book;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.repository.AuthorRepository;
import com.baris.ertas.LibraryApplicaton.repository.BookRepository;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAllBooks() {
        List<Book> books = bookRepository.findAll().stream().collect(Collectors.toList());
        return books;
    }

    public Book getBookByName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);

    }

}
