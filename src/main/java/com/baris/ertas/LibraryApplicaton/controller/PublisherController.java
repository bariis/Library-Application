package com.baris.ertas.LibraryApplicaton.controller;

import com.baris.ertas.LibraryApplicaton.model.Author;
import com.baris.ertas.LibraryApplicaton.model.Publisher;
import com.baris.ertas.LibraryApplicaton.service.AuthorService;
import com.baris.ertas.LibraryApplicaton.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping("/publishers")
    public String createPublisher(Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/home";
    }

}