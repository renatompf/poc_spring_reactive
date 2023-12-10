package io.renatofreire.poc_spring_reactive.controller;

import io.renatofreire.poc_spring_reactive.dto.BookRequest;
import io.renatofreire.poc_spring_reactive.model.Book;
import io.renatofreire.poc_spring_reactive.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{isbn}")
    public Mono<Book> findById(@PathVariable String isbn) {
        return bookService.findByISBN(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> create(@RequestBody BookRequest request) {
        return bookService.save(request);
    }

    @GetMapping(value = "/publisher")
    public Flux<Book> findByPublisher(@RequestParam String name) {
        return bookService.findByPublisher(name);
    }

    @GetMapping(value = "/title")
    public Mono<Book> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping(value = "/contains")
    public Flux<Book> findAllContaining(@RequestParam String content) {
        return bookService.findAllContaining(content);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return bookService.deleteByISBN(id);
    }

}
