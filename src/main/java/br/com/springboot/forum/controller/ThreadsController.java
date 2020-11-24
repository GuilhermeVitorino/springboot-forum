package br.com.springboot.forum.controller;

import br.com.springboot.forum.controller.dto.DetailedThreadDTO;
import br.com.springboot.forum.controller.dto.ThreadDTO;
import br.com.springboot.forum.controller.form.ThreadForm;
import br.com.springboot.forum.controller.form.UpdateThreadForm;
import br.com.springboot.forum.model.Thread;
import br.com.springboot.forum.repository.CourseRepository;
import br.com.springboot.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/threads")
public class ThreadsController {

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<ThreadDTO> listThreads(String courseName){
        if (courseName == null) {
            List<Thread> threads = threadRepository.findAll();
            return ThreadDTO.convert(threads);
        } else {
            //List<Thread> threads = threadRepository.findByCourseName(courseName);
            List<Thread> threads = threadRepository.otherWayToFindByCourseName(courseName);
            return ThreadDTO.convert(threads);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ThreadDTO> add(@RequestBody @Valid ThreadForm threadForm, UriComponentsBuilder uriBuilder) {
        Thread thread = threadForm.convert(courseRepository);
        threadRepository.save(thread);

        URI uri = uriBuilder.path("/threads/{id}").buildAndExpand(thread.getId()).toUri();
        return ResponseEntity.created(uri).body(new ThreadDTO(thread));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedThreadDTO> detail(@PathVariable Long id) {

        Optional<Thread> thread = threadRepository.findById(id);

        if (thread.isPresent()) {
            return ResponseEntity.ok(new DetailedThreadDTO(thread.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ThreadDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateThreadForm form) {

        Optional<Thread> optionalThread = threadRepository.findById(id);

        if (optionalThread.isPresent()) {
            Thread thread = form.update(id, threadRepository);
            return ResponseEntity.ok(new ThreadDTO(thread));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Thread> thread = threadRepository.findById(id);

        if (thread.isPresent()) {
            threadRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
