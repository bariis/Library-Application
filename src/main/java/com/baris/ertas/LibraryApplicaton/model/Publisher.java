package com.baris.ertas.LibraryApplicaton.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String publisherName;
    private String publisherDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<Book> books;

    protected Publisher() {}

    public Publisher(String publisherName, String publisherDescription) {
        this.publisherName = publisherName;
        this.publisherDescription = publisherDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonManagedReference
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherDescription() {
        return publisherDescription;
    }

    public void setPublisherDescription(String publisherDescription) {
        this.publisherDescription = publisherDescription;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", publisherDescription='" + publisherDescription + '\'' +
                '}';
    }
}
