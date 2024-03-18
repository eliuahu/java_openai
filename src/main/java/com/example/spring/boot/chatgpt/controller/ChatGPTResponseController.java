package com.example.spring.boot.chatgpt.controller;

import com.example.spring.boot.chatgpt.model.entity.ChatGPTResponseEntity;
import com.example.spring.boot.chatgpt.service.ChatGPTResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat-gpt-responses")
public class ChatGPTResponseController {
    private final ChatGPTResponseService chatGPTResponseService;

    @Autowired
    public ChatGPTResponseController(ChatGPTResponseService chatGPTResponseService) {
        this.chatGPTResponseService = chatGPTResponseService;
    }

    @GetMapping
    public List<ChatGPTResponseEntity> findAll() {
        return chatGPTResponseService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<ChatGPTResponseEntity> findById(@PathVariable String id) {
        return chatGPTResponseService.findById(id);
    }

    @PostMapping("/create")
    public ChatGPTResponseEntity save(@RequestBody ChatGPTResponseEntity chatGPTResponseEntity) {
        return chatGPTResponseService.save(chatGPTResponseEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        chatGPTResponseService.deleteById(id);
    }
}
