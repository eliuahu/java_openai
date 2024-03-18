package com.example.spring.boot.chatgpt.service;

import com.example.spring.boot.chatgpt.model.entity.SpecificationEntity;
import com.example.spring.boot.chatgpt.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecificationService {
    private final SpecificationRepository specificationRepository;

    @Autowired
    public SpecificationService(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    public List<SpecificationEntity> findAll() {
        return specificationRepository.findAll();
    }

    public Optional<SpecificationEntity> findById(Long id) {
        return specificationRepository.findById(id);
    }

    public SpecificationEntity save(SpecificationEntity specificationEntity) {
        return specificationRepository.save(specificationEntity);
    }

    public void deleteById(Long id) {
        specificationRepository.deleteById(id);
    }
}