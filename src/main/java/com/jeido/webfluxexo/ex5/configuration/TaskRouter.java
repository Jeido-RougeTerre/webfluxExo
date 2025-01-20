package com.jeido.webfluxexo.ex5.configuration;

import com.jeido.webfluxexo.ex5.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> routes(TaskHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/api/tasks"), handler::getAllTasks)
                .andRoute(RequestPredicates.GET("/api/tasks/{id}"), handler::getTaskById)
                .andRoute(RequestPredicates.POST("/api/tasks"), handler::createTask)
                .andRoute(RequestPredicates.PUT("/api/tasks/{id}"), handler::updateTask)
                .andRoute(RequestPredicates.DELETE("/api/tasks/{id}"), handler::deleteTask);
    }
}
