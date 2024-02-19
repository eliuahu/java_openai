package com.example.spring.boot.chatgpt.model.request;

import java.io.Serializable;
import java.util.List;

import com.example.spring.boot.chatgpt.model.Message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTRequest implements Serializable {

    private String model;
    private List<Message> messages;
}
