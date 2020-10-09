package br.com.springboot.forum.controller.dto;

import br.com.springboot.forum.model.Answer;
import br.com.springboot.forum.model.Thread;
import br.com.springboot.forum.model.ThreadStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailedThreadDTO {

    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String author;
    private ThreadStatus status;
    private List<AnswerDTO> answers;

    public DetailedThreadDTO(Thread thread) {
        this.id = thread.getId();
        this.title = thread.getTitle();
        this.message = thread.getMessage();
        this.creationDate = thread.getCreationDate();
        this.author = thread.getAuthor().getName();
        this.status = thread.getStatus();
        this.id = thread.getId();
        this.answers = new ArrayList<>();
        this.answers.addAll(thread.getAnswers().stream().map(AnswerDTO::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public ThreadStatus getStatus() {
        return status;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }
}
