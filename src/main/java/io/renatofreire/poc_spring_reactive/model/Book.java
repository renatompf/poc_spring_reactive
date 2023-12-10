package io.renatofreire.poc_spring_reactive.model;

import io.renatofreire.poc_spring_reactive.dto.BookRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book")
public class Book {

    @Id
    private Long id;
    @Column("isbn")
    private String isbn;
    @Column("title")
    private String title;
    @Column("publisher")
    private String publisher;

    public Book() {
    }

    public Book(String isbn, String title, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
    }

    public Book(BookRequest bookRequest) {
        this.isbn = bookRequest.isbn();
        this.title = bookRequest.title();
        this.publisher = bookRequest.publisher();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}

