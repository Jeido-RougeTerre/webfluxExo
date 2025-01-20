package com.jeido.webfluxexo.ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ErrorHandlingController {

    @GetMapping("error-resume")
    public Flux<String> resume() {
        return Flux.just("A", "B", "C", "D", "E", "F").map(s -> {
            if (s.equals("D")) {
                throw new RuntimeException("C passed now going to default");
            }
            return s;
        }).onErrorResume(e -> Flux.just("Default1", "Default2"));
    }

    @GetMapping("error-continue")
    public Flux<Integer> continuation() {
        return Flux.range(1,5).map(n -> {
            if (n == 2) {
                throw new RuntimeException("2 is a bad number!");
            }
            return n;
        }).onErrorContinue((throwable, o) -> {});
    }
}
