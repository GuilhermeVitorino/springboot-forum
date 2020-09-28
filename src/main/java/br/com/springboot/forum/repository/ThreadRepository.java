package br.com.springboot.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springboot.forum.model.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

}
