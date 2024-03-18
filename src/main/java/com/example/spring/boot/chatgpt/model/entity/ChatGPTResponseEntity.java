package com.example.spring.boot.chatgpt.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chat_gpt_response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGPTResponseEntity {
    @Id
    private String id;

    @Column(name = "object")
    private String object;

    @Column(name = "model")
    private String model;

    @Column(name = "created")
    private LocalDate created;

    @ManyToMany(mappedBy = "chatGPTResponses")
    @JsonIgnore
    private Set<SpecificationEntity> specifications = new HashSet<>();

    @OneToMany(mappedBy = "chatGPTResponse", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SourceEntity> sources = new HashSet<>();

    public Set<SpecificationEntity> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<SpecificationEntity> specifications) {
        this.specifications = specifications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Set<SourceEntity> getSources() {
        return sources;
    }

    public void setSources(Set<SourceEntity> sources) {
        this.sources = sources;
    }
}