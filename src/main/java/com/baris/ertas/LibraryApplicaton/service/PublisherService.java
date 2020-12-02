package com.baris.ertas.LibraryApplicaton.service;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    public List<Publisher> findAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll().stream().collect(Collectors.toList());
        return publishers;
    }

    public Publisher save(Publisher publisher) {
       return publisherRepository.save(publisher);
    }

}
