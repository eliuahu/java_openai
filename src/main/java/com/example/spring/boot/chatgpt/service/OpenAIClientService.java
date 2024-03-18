package com.example.spring.boot.chatgpt.service;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.spring.boot.chatgpt.model.*;
import com.example.spring.boot.chatgpt.model.entity.*;
import com.example.spring.boot.chatgpt.model.entity.enums.SpecificationDescription;
import com.example.spring.boot.chatgpt.model.response.Choice;
import com.example.spring.boot.chatgpt.repository.ChatGPTResponseRepository;
import com.example.spring.boot.chatgpt.repository.SpecificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring.boot.chatgpt.config.OpenAIClientConfig;
import com.example.spring.boot.chatgpt.interfaces.OpenAIClient;
import com.example.spring.boot.chatgpt.model.request.ChatGPTRequest;
import com.example.spring.boot.chatgpt.model.request.ChatRequest;
import com.example.spring.boot.chatgpt.model.response.ChatGPTResponse;


@Service
public class OpenAIClientService {

    private final OpenAIClient openAIClient;
    private final OpenAIClientConfig openAIClientConfig;
    private final ChatGPTResponseRepository chatGPTResponseRepository;

    private final SpecificationRepository specificationRepository;

    public OpenAIClientService(OpenAIClient openAIClient, OpenAIClientConfig openAIClientConfig, ChatGPTResponseRepository chatGPTResponseRepository, ObjectMapper objectMapper, SpecificationRepository specificationRepository) {
        this.openAIClient = openAIClient;
        this.openAIClientConfig = openAIClientConfig;
        this.chatGPTResponseRepository = chatGPTResponseRepository;
        objectMapper.registerModule(new JavaTimeModule());
        this.specificationRepository = specificationRepository;
    }
    private static final String ROLE_USER = "user";

    public ChatGPTResponse chat(ChatRequest chatRequest) {

        Message message = Message.builder().role(ROLE_USER).content(chatRequest.getQuestion()).build();

        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder().model(openAIClientConfig.getModel())
                .messages(Collections.singletonList(message)).build();

        ChatGPTResponse chatGPTResponse = openAIClient.chat(chatGPTRequest);

        saveChatGPTResponse(chatGPTResponse);

        return chatGPTResponse;
    }

    private void saveChatGPTResponse(ChatGPTResponse chatGPTResponse) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            ChatGPTResponseEntity chatGPTResponseEntity = objectMapper.readValue(objectMapper.writeValueAsString(chatGPTResponse), ChatGPTResponseEntity.class);
            chatGPTResponseRepository.save(chatGPTResponseEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void assignSpecificationsToChat(String chatGPTResponseId, List<SpecificationDescription> descriptions) {
        ChatGPTResponseEntity chatGPTResponseEntity = chatGPTResponseRepository.findById(chatGPTResponseId)
                .orElseThrow(() -> new EntityNotFoundException("ChatGPTResponseEntity not found with ID: " + chatGPTResponseId));

        List<SpecificationEntity> existingSpecifications = specificationRepository.findByDescriptionIn(descriptions);
        Map<SpecificationDescription, SpecificationEntity> specificationMap = new HashMap<>();

        for (SpecificationEntity specification : existingSpecifications) {
            specificationMap.putIfAbsent(specification.getDescription(), specification);
        }

        Set<SpecificationEntity> specificationEntities = new HashSet<>();
        for (SpecificationDescription description : descriptions) {
            SpecificationEntity specificationEntity = specificationMap.get(description);
            if (specificationEntity == null) {
                specificationEntity = new SpecificationEntity();
                specificationEntity.setDescription(description);
                specificationRepository.save(specificationEntity);
            }

            specificationEntity.getChatGPTResponses().add(chatGPTResponseEntity);
            specificationEntities.add(specificationEntity);
        }

        chatGPTResponseEntity.getSpecifications().addAll(specificationEntities);
        chatGPTResponseRepository.save(chatGPTResponseEntity);
    }

}