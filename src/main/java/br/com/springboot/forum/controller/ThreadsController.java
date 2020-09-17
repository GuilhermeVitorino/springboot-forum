package br.com.springboot.forum.controller;

import br.com.springboot.forum.model.Course;
import br.com.springboot.forum.model.Thread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
public class ThreadsController {

    @RequestMapping("/threads")
    public List<Thread> listThreads(){
        Thread thread = new Thread("Doubt", "Doubt about springboot", new Course("Spring", "Development"));
        return Arrays.asList(thread, thread, thread);
    }

}
