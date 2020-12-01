package com.baris.ertas.LibraryApplicaton.repository;

import com.baris.ertas.LibraryApplicaton.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookName(String bookName);
    List<Book> findByBookNameIgnoreCaseContainingOrSeriesNameIgnoreCaseContainingOrAuthor_AuthorNameIgnoreCaseContainingOrIsbnNumberIgnoreCaseContaining(String keyword, String keyword2, String keyword3, String keyword4);
}
