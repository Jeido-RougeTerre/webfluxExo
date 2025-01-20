package com.jeido.webfluxexo.ex5.handler;

import com.jeido.webfluxexo.ex5.entity.Task;
import com.jeido.webfluxexo.ex5.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TaskHandler {

    private final TaskService taskService;

    public TaskHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public Mono<ServerResponse> getAllTasks(ServerRequest request) {
        return ServerResponse.ok().body(taskService.getTasks(), Task.class);
    }

    public Mono<ServerResponse> getTaskById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return taskService.getTask(id)
                .flatMap(task -> ServerResponse.ok().bodyValue(task))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> createTask(ServerRequest request) {
        return request.bodyToMono(Task.class)
                .flatMap(taskService::createTask)
                .flatMap(task -> ServerResponse.created(request.uri()).bodyValue(task));
    }

    public Mono<ServerResponse> updateTask(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return request.bodyToMono(Task.class)
                .flatMap(t -> taskService.updateTask(id, t))
                .flatMap(t -> ServerResponse.ok().bodyValue(t))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> deleteTask(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        return ServerResponse.ok().body(taskService.deleteTask(id), String.class);
    }


}
