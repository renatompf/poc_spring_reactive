package io.renatofreire.poc_spring_reactive.service;

import io.renatofreire.poc_spring_reactive.dto.BookRequest;
import io.renatofreire.poc_spring_reactive.model.Book;
import io.renatofreire.poc_spring_reactive.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> findAll(){
        return bookRepository.findAll();
    }

    public Mono<Book> findByISBN(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public Flux<Book> findByPublisher(String publisher){
        return bookRepository.findAllByPublisher(publisher);
    }

    public Flux<Book> findAllContaining(String content){
        return bookRepository.findByTitleContainingIgnoreCase(content);
    }

    public Mono<Void> deleteByISBN(String ISBN){
        return bookRepository.deleteByIsbn(ISBN);
    }

    public Mono<Book> save(BookRequest request) {
        return bookRepository.save(new Book(request));
    }

    public Mono<Book> findByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title);
    }
}
