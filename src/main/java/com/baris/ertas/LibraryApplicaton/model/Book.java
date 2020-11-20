package com.baris.ertas.LibraryApplicaton.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;

public class Book {

    private String bookName;
    private String bookSubtitle;
    private String seriesName;
    private String bookOfAuthor;
    private String bookOfPublisher;
    private String isbnNumber;
    private String bookDescription;

    private Author author;

    protected Book() {}

    public Book(String bookName, String bookSubtitle, String seriesName, String bookOfAuthor, String bookOfPublisher, String isbnNumber, String bookDescription) {
        this.bookName = bookName;
        this.bookSubtitle = bookSubtitle;
        this.seriesName = seriesName;
        this.bookOfAuthor = bookOfAuthor;
        this.bookOfPublisher = bookOfPublisher;
        this.isbnNumber = isbnNumber;
        this.bookDescription = bookDescription;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookSubtitle() {
        return bookSubtitle;
    }

    public void setBookSubtitle(String bookSubtitle) {
        this.bookSubtitle = bookSubtitle;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getBookOfauthor() {
        return bookOfAuthor;
    }

    public void setBookOfauthor(String bookOfauthor) {
        this.bookOfAuthor = bookOfauthor;
    }

    public String getBookOfPublisher() {
        return bookOfPublisher;
    }

    public void setBookOfPublisher(String bookOfPublisher) {
        this.bookOfPublisher = bookOfPublisher;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookSubtitle='" + bookSubtitle + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", bookOfauthor='" + bookOfAuthor + '\'' +
                ", bookOfPublisher='" + bookOfPublisher + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
