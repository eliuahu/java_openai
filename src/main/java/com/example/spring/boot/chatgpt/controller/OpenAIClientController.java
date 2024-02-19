package com.example.spring.boot.chatgpt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.chatgpt.model.request.ChatRequest;
import com.example.spring.boot.chatgpt.model.response.ChatGPTResponse;
import com.example.spring.boot.chatgpt.service.OpenAIClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest) {
        return openAIClientService.chat(chatRequest);
    }

}
