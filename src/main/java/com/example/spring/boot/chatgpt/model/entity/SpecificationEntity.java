package com.example.spring.boot.chatgpt.model.entity;

import com.example.spring.boot.chatgpt.model.entity.enums.SpecificationDescription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specification")
public class SpecificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "chat_gpt_response_specification",
            joinColumns = @JoinColumn(name = "specification_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_gpt_response_id"))
    private Set<ChatGPTResponseEntity> chatGPTResponses = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "description")
    private SpecificationDescription description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ChatGPTResponseEntity> getChatGPTResponses() {
        return chatGPTResponses;
    }

    public void setChatGPTResponses(Set<ChatGPTResponseEntity> chatGPTResponses) {
        this.chatGPTResponses = chatGPTResponses;
    }

    public SpecificationDescription getDescription() {
        return description;
    }

    public void setDescription(SpecificationDescription description) {
        this.description = description;
    }
}