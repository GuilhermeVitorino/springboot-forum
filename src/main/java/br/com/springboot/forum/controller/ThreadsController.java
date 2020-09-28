package br.com.springboot.forum.controller;

import br.com.springboot.forum.controller.dto.ThreadDTO;
import br.com.springboot.forum.model.Thread;
import br.com.springboot.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThreadsController {

    @Autowired
    ThreadRepository threadRepository;

    @RequestMapping("/threads")
    public List<ThreadDTO> listThreads(){
        List<Thread> threads = threadRepository.findAll();
        return ThreadDTO.converter(threads);
    }

}
