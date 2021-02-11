package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    private final MessageRepository repository;

    MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/messages")
    List<Message> all() {
        return repository.findAll();
    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {
        return repository.save(newMessage);
    }

    @GetMapping("/messages/{id}")
    Message one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
