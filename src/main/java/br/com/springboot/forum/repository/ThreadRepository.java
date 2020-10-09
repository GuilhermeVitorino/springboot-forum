package br.com.springboot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springboot.forum.model.Thread;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

    List<Thread> findByCourseName(String courseName);

    @Query("SELECT t FROM Thread t WHERE t.course.name = :courseName")
    List<Thread> otherWayToFindByCourseName(@Param("courseName") String courseName);
}
