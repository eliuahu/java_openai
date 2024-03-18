package com.example.spring.boot.chatgpt.model.request;

import com.example.spring.boot.chatgpt.model.entity.enums.SpecificationDescription;

import java.util.List;

public class AssignSpecificationRequest {
    private String chatGPTResponseId;
    private List<SpecificationDescription> descriptions;

    public String getChatGPTResponseId() {
        return chatGPTResponseId;
    }

    public void setChatGPTResponseId(String chatGPTResponseId) {
        this.chatGPTResponseId = chatGPTResponseId;
    }

    public List<SpecificationDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<SpecificationDescription> descriptions) {
        this.descriptions = descriptions;
    }
}
