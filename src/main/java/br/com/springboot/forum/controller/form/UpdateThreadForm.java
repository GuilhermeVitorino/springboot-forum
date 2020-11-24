package br.com.springboot.forum.controller.form;

import br.com.springboot.forum.model.Course;
import br.com.springboot.forum.model.Thread;
import br.com.springboot.forum.repository.CourseRepository;
import br.com.springboot.forum.repository.ThreadRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateThreadForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 10)
    private String message;

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

    public Thread update(Long id, ThreadRepository threadRepository) {

        Thread thread = threadRepository.getOne(id);
        thread.setTitle(this.title);
        thread.setMessage(this.message);
        return thread;

    }
}
