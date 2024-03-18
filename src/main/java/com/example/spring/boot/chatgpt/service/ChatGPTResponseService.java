package com.example.spring.boot.chatgpt.service;

import com.example.spring.boot.chatgpt.model.entity.ChatGPTResponseEntity;
import com.example.spring.boot.chatgpt.repository.ChatGPTResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatGPTResponseService {

    @Autowired
    private ChatGPTResponseRepository chatGPTResponseRepository;

    public List<ChatGPTResponseEntity> findAll() {
        return chatGPTResponseRepository.findAll();
    }

    public Optional<ChatGPTResponseEntity> findById(String id) {
        return chatGPTResponseRepository.findById(id);
    }

    public ChatGPTResponseEntity save(ChatGPTResponseEntity chatGPTResponseEntity) {
        return chatGPTResponseRepository.save(chatGPTResponseEntity);
    }

    public void deleteById(String id) {
        chatGPTResponseRepository.deleteById(id);
    }
}
