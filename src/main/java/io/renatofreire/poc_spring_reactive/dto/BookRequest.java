package io.renatofreire.poc_spring_reactive.dto;

public record BookRequest(
        String isbn,
        String title,
        String publisher
) {
}
