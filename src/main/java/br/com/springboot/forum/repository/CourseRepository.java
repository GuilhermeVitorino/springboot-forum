package br.com.springboot.forum.repository;

import br.com.springboot.forum.model.Course;
import br.com.springboot.forum.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String courseName);

}
