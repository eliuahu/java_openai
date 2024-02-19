package com.example.spring.boot.chatgpt.model.response;

import java.io.Serializable;

import com.example.spring.boot.chatgpt.model.Message;


import lombok.Data;

@Data
public class Choice implements Serializable {

    private Integer index;
    private Message message;
    private String finishReason;

}
