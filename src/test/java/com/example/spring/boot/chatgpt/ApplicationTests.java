package com.example.spring.boot.chatgpt;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatControllerIntegrationTest {


    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + 8080 + "/api/v1/chat";
    }

    @Test
    void testValidQuestion() {
        String question = "{\"question\":\"Say hello?\"}";
        ResponseEntity<String> response = restTemplate.postForEntity(baseUrl, createRequestEntity(question), String.class);
        assertEquals(200, response.getStatusCode().value());
    }


    private HttpEntity<String> createRequestEntity(String payload) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return new HttpEntity<>(payload, headers);
    }
}
