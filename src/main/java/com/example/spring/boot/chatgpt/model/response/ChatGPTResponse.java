package com.example.spring.boot.chatgpt.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ChatGPTResponse implements Serializable {

    private String id;
    private String object;
    private String model;
    private LocalDate created;
    private List<Choice> choices;
    private Usage usage;

}
