package com.baris.ertas.LibraryApplicaton.repository;

import com.baris.ertas.LibraryApplicaton.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByBookName(String bookName);

}
