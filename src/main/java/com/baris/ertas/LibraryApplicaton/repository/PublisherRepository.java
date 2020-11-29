package com.baris.ertas.LibraryApplicaton.repository;

import com.baris.ertas.LibraryApplicaton.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    boolean existsByPublisherName(String publisherName);

}
