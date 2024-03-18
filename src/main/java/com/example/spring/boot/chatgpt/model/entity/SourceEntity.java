package com.example.spring.boot.chatgpt.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "source")
public class SourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "chat_gpt_response_id")
    @JsonIgnore
    private ChatGPTResponseEntity chatGPTResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChatGPTResponseEntity getChatGPTResponse() {
        return chatGPTResponse;
    }

    public void setChatGPTResponse(ChatGPTResponseEntity chatGPTResponse) {
        this.chatGPTResponse = chatGPTResponse;
    }
}
