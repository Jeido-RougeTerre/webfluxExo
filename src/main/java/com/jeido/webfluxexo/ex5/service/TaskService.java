package com.jeido.webfluxexo.ex5.service;

import com.jeido.webfluxexo.ex5.entity.Task;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskService {

    private final Map<Integer, Task> tasks = new HashMap<>();

    public TaskService() {
        tasks.put(1, new Task(1, "Dilation of Right Axillary Artery with Four or More Drug-eluting Intraluminal Devices, Percutaneous Endoscopic Approach", false));
        tasks.put(2, new Task(2, "Restriction of Upper Vein with Intraluminal Device, Percutaneous Approach", true));
    }

    public Flux<Task> getTasks() {
        return Flux.fromIterable(tasks.values());
    }

    public Mono<Task> getTask(int id) {
        return Mono.justOrEmpty(tasks.get(id));
    }

    public Mono<Task> createTask(Task task) {
        task.setId(tasks.size() + 1);
        tasks.put(task.getId(), task);
        return Mono.just(task);
    }

    public Mono<Task> updateTask(int id, Task task) {
        return Mono.justOrEmpty(tasks.get(id)).map(t -> {
            if (task.getDescription() != null) {
                t.setDescription(task.getDescription());
            }
            t.setCompleted(task.isCompleted());
            return t;
        });
    }

    public Mono<String> deleteTask(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return Mono.just("Deleted Task#" + id);
        }
        return Mono.just("Task#" + id + " not found!");
    }

}
