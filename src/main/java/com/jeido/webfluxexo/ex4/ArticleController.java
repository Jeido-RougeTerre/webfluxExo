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
    public Flux<String> getAllArticleTitles() {
        return Flux.just(
                new Article(UUID.randomUUID(), "Introduction to Spring WebFlux"),
                new Article(UUID.randomUUID(), "Reactive Programming with Project Reactor"),
                new Article(UUID.randomUUID(), "Building APIs with Spring Boot")
        ).map(Article::getTitle);
    }
}
