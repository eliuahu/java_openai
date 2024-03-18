package com.example.spring.boot.chatgpt.repository;

import com.example.spring.boot.chatgpt.model.entity.SourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<SourceEntity, Long> {
}
