package com.baris.ertas.LibraryApplicaton.repository;

import com.baris.ertas.LibraryApplicaton.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


}
