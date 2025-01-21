package com.jeido.webfluxexo.ex7.service;

import com.jeido.webfluxexo.ex7.entity.User;
import com.jeido.webfluxexo.ex7.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(String id, User user) {
        return userRepository.findById(id)
                .flatMap(u -> {

                    if (user.getName() != null) {
                        u.setName(user.getName());
                    }

                    if (user.getEmail() != null) {
                        u.setEmail(user.getEmail());
                    }

                    u.setActive(user.isActive());

                    return userRepository.save(u);
                });
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
}
