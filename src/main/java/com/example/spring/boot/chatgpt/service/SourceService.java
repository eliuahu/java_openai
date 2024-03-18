package com.example.spring.boot.chatgpt.service;

import com.example.spring.boot.chatgpt.model.entity.ChatGPTResponseEntity;
import com.example.spring.boot.chatgpt.model.entity.SourceEntity;
import com.example.spring.boot.chatgpt.repository.ChatGPTResponseRepository;
import com.example.spring.boot.chatgpt.repository.SourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SourceService {
    private final SourceRepository sourceRepository;
    private final ChatGPTResponseRepository chatGPTResponseRepository;

    public SourceService(SourceRepository sourceRepository, ChatGPTResponseRepository chatGPTResponseRepository) {
        this.sourceRepository = sourceRepository;
        this.chatGPTResponseRepository = chatGPTResponseRepository;
    }

    public void addSourcesToChatGPTResponse(String chatGPTResponseId, List<SourceEntity> sources) {
        ChatGPTResponseEntity chatGPTResponse = chatGPTResponseRepository.findById(chatGPTResponseId)
                .orElseThrow(() -> new RuntimeException("ChatGPT response not found"));

        sources.forEach(source -> {
            source.setChatGPTResponse(chatGPTResponse);
            sourceRepository.save(source);
        });

        chatGPTResponse.getSources().addAll(sources);
        chatGPTResponseRepository.save(chatGPTResponse);
    }


    public List<SourceEntity> findAll() {
        return sourceRepository.findAll();
    }

    public Optional<SourceEntity> findById(Long id) {
        return sourceRepository.findById(id);
    }

    public SourceEntity save(SourceEntity source) {
        return sourceRepository.save(source);
    }

    public void deleteById(Long id) {
        sourceRepository.deleteById(id);
    }
}
