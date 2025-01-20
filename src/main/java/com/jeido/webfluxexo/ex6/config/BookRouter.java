package com.jeido.webfluxexo.ex6.config;

import com.jeido.webfluxexo.ex6.handler.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class BookRouter {

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/books"), bookHandler::getBookByTitleOrAll)
                .andRoute(RequestPredicates.GET("/api/books/search"), bookHandler::getBookByTitleOrAll)
                .andRoute(RequestPredicates.POST("/api/books"), bookHandler::createBook)
                .andRoute(RequestPredicates.GET("/api/books/{id}"), bookHandler::getBookById)
                .andRoute(RequestPredicates.DELETE("/api/books/{id}"), bookHandler::deleteBook);
    }
}
