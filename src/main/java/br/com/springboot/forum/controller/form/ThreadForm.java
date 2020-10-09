package br.com.springboot.forum.controller.form;

import br.com.springboot.forum.model.Course;
import br.com.springboot.forum.model.Thread;
import br.com.springboot.forum.repository.CourseRepository;

import java.time.LocalDateTime;

public class ThreadForm {

    private String title;
    private String message;
    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Thread convert(CourseRepository courseRepository){
        Course course = courseRepository.findByName(courseName);
        return new Thread(title, message, course);
    }

}
