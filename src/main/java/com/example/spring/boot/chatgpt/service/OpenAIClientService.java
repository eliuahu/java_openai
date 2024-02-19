package com.example.spring.boot.chatgpt.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.example.spring.boot.chatgpt.config.OpenAIClientConfig;
import com.example.spring.boot.chatgpt.interfaces.OpenAIClient;
import com.example.spring.boot.chatgpt.model.Message;
import com.example.spring.boot.chatgpt.model.request.ChatGPTRequest;
import com.example.spring.boot.chatgpt.model.request.ChatRequest;
import com.example.spring.boot.chatgpt.model.response.ChatGPTResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;

    private static final String ROLE_USER = "user";

    public ChatGPTResponse chat(ChatRequest chatRequest) {

        Message message = Message.builder().role(ROLE_USER).content(chatRequest.getQuestion()).build();

        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder().model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message)).build();

        return openAIClient.chat(chatGPTRequest);
    }

}
