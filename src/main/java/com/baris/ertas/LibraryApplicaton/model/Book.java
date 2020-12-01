package com.baris.ertas.LibraryApplicaton.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;
    private String bookSubtitle;
    private String seriesName;

    @Column(unique = true)
    private String isbnNumber;

    private String bookDescription;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    public Book() {}

    public Book(String bookName, String bookSubtitle, String seriesName, String isbnNumber, String bookDescription, Author author, Publisher publisher) {
        this.bookName = bookName;
        this.bookSubtitle = bookSubtitle;
        this.seriesName = seriesName;
        this.isbnNumber = isbnNumber;
        this.bookDescription = bookDescription;
        this.author = author;
        this.publisher = publisher;
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

    @JsonBackReference
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonBackReference
    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookSubtitle='" + bookSubtitle + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", isbnNumber='" + isbnNumber + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
