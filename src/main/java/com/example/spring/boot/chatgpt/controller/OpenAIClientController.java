package com.example.spring.boot.chatgpt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.boot.chatgpt.model.request.ChatRequest;
import com.example.spring.boot.chatgpt.model.request.AssignSpecificationRequest;
import com.example.spring.boot.chatgpt.model.response.ChatGPTResponse;
import com.example.spring.boot.chatgpt.service.OpenAIClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    @Autowired
    public OpenAIClientController(OpenAIClientService openAIClientService) {
        this.openAIClientService = openAIClientService;
    }

    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatGPTResponse chat(@RequestBody ChatRequest chatRequest) throws JsonProcessingException {
        return openAIClientService.chat(chatRequest);
    }

    @PostMapping("/assign-specifications")
    public ResponseEntity<Void> assignSpecifications(@RequestBody AssignSpecificationRequest request) {
        openAIClientService.assignSpecificationsToChat(request.getChatGPTResponseId(), request.getDescriptions());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
