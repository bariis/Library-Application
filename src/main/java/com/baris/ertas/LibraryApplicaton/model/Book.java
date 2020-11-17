package com.baris.ertas.LibraryApplicaton.model;

public class Book {

    private String bookName;
    private String bookSubtitle;
    private String seriesName;
    private String bookOfauthor;
    private String bookOfPublisher;
    private String isbnNumber;
    private String bookDescription;

    public Book(String bookName, String bookSubtitle, String seriesName, String bookOfauthor, String bookOfPublisher, String isbnNumber, String bookDescription) {
        this.bookName = bookName;
        this.bookSubtitle = bookSubtitle;
        this.seriesName = seriesName;
        this.bookOfauthor = bookOfauthor;
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
        return bookOfauthor;
    }

    public void setBookOfauthor(String bookOfauthor) {
        this.bookOfauthor = bookOfauthor;
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
                ", bookOfauthor='" + bookOfauthor + '\'' +
                ", bookOfPublisher='" + bookOfPublisher + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                '}';
    }
}
