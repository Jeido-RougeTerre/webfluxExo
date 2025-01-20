package com.jeido.webfluxexo.ex6.handler;

import com.jeido.webfluxexo.ex6.entity.Book;
import com.jeido.webfluxexo.ex6.service.BookService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class BookHandler {

    private final BookService bookService;

    public BookHandler(BookService bookService) {
        this.bookService = bookService;
    }


    public Mono<ServerResponse> getBookById(ServerRequest request) {
        return bookService.findById(request.pathVariable("id"))
                .flatMap(book -> ServerResponse.ok().bodyValue(book))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getBookByTitleOrAll(ServerRequest request) {
        String title = request.queryParam("title").orElse(null);
        if (title == null) {
            return ServerResponse.ok().body(bookService.findAll(), Book.class);
        }
        return ServerResponse.ok().body(
                bookService.findAll()
                        .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase())), Book.class
        ).switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createBook(ServerRequest request) {
        return request.bodyToMono(Book.class)
                .flatMap(bookService::save)
                .flatMap(book -> ServerResponse.created(request.uri()).bodyValue(book));
    }

    public Mono<ServerResponse> deleteBook(ServerRequest request) {
        return bookService.deleteById(request.pathVariable("id"))
                .flatMap(book -> ServerResponse.ok().bodyValue(book))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
