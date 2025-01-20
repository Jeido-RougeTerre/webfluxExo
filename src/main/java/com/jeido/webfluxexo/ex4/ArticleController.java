package com.jeido.webfluxexo.ex4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @GetMapping
    public Flux<String> getArticles() {
        return Flux.just(
                new Articles(UUID.randomUUID(), "Introduction to Spring WebFlux"),
                new Articles(UUID.randomUUID(), "Reactive Programming with Project Reactor"),
                new Articles(UUID.randomUUID(), "Building APIs with Spring Boot")
        ).map(Articles::getTitle);
    }
}
