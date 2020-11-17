package com.baris.ertas.LibraryApplicaton.model;

public class Publisher {

    private String publisherName;
    private String publisherDescription;

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
