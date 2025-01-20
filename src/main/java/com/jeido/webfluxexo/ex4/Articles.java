package com.jeido.webfluxexo.ex4;

import java.util.UUID;

public class Articles {
    private UUID id;
    private String title;

    public Articles(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
