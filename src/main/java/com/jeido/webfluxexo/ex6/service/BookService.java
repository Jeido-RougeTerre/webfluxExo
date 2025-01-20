package com.jeido.webfluxexo.ex6.service;

import com.jeido.webfluxexo.ex6.entity.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private final Map<String, Book> books = new HashMap<>();

    public BookService() {
        books.put("9788412098570", new Book("9788412098570", "Mausritter", "Isaac Williams"));
    }

    public Flux<Book> findAll() {
        return Flux.fromIterable(books.values());
    }

    public Mono<Book> findById(String id) {
        return Mono.justOrEmpty(books.get(id));
    }

    public Mono<Book> save(Book book) {
        books.put(book.getIsbn(), book);
        return Mono.just(book);
    }

    public Mono<String> deleteById(String id) {
        if (books.containsKey(id)) {
            books.remove(id);
            return Mono.just("Deleted Book#" + id);
        }
        return Mono.empty();
    }
}
