package com.example.spring.boot.chatgpt.repository;

import com.example.spring.boot.chatgpt.model.entity.SpecificationEntity;
import com.example.spring.boot.chatgpt.model.entity.enums.SpecificationDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<SpecificationEntity, Long> {
    List<SpecificationEntity> findByDescriptionIn(List<SpecificationDescription> descriptions);
}

