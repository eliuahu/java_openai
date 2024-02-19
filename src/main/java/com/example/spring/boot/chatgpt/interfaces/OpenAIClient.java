package com.example.spring.boot.chatgpt.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.boot.chatgpt.config.OpenAIClientConfig;
import com.example.spring.boot.chatgpt.model.request.ChatGPTRequest;
import com.example.spring.boot.chatgpt.model.response.ChatGPTResponse;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {

    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

}
