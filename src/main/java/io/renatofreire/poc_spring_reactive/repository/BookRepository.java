package io.renatofreire.poc_spring_reactive.repository;

import io.renatofreire.poc_spring_reactive.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

    Flux<Book> findAllByPublisher(String publisher);

    Mono<Book> findByTitleIgnoreCase(String title);

    Mono<Book> findByIsbn(String isbn);

    Flux<Book> findByTitleContainingIgnoreCase(String contains);

    Mono<Void> deleteByIsbn(String isbn);

}
