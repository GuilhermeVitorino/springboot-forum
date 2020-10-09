package br.com.springboot.forum.controller.dto;

import br.com.springboot.forum.model.Answer;

import java.time.LocalDateTime;

public class AnswerDTO {

    private Long id;
    private String  message;
    private LocalDateTime creationDate;
    private String authorName;

    public AnswerDTO(Answer answer) {
        this.id = answer.getId();
        this.message = answer.getMessage();
        this.creationDate = answer.getCreationDate();
        this.authorName = answer.getAuthor().getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }


    public LocalDateTime getCreationDate() {
        return creationDate;
    }


    public String getAuthorName() {
        return authorName;
    }

}
