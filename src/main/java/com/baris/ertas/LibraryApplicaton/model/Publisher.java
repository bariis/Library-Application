package com.baris.ertas.LibraryApplicaton.model;


import javax.persistence.*;
import java.util.List;


public class Publisher {

    private long id;
    private String publisherName;
    private String publisherDescription;

    protected Publisher() {}

    public Publisher(String publisherName, String publisherDescription) {
        this.publisherName = publisherName;
        this.publisherDescription = publisherDescription;
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
