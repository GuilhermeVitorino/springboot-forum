package br.com.springboot.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.springboot.forum.model.Thread;

public class ThreadDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;

    public ThreadDTO(Thread thread) {
        this.id = thread.getId();
        this.title = thread.getTitle();
        this.message = thread.getMessage();
        this.creationDate = thread.getCreationDate();
    }

    public static List<ThreadDTO> converter(List<Thread> threads) {
        return threads.stream().map(ThreadDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
