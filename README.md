# Spring Boot Integration APIs of OpenAI

## Requirements

1. Java - 17
2. Maven - 3.x.x > 


OpenAI API refers to a set of artificial intelligence models and tools provided by OpenAI, an artificial intelligence research laboratory. The OpenAI API enables developers to access state-of-the-art natural language processing (NLP) and other AI capabilities through a simple interface. It allows developers to integrate powerful AI models into their applications without needing to build and train the models from scratch.

The OpenAI API offers various models tailored for different tasks, such as text generation, language translation, question answering, and more. One of the most well-known models provided by the OpenAI API is GPT (Generative Pre-trained Transformer), which is capable of generating human-like text based on a given prompt or context.

Developers can access the OpenAI API through HTTP requests, making it easy to integrate into a wide range of applications and programming languages. By leveraging the OpenAI API, developers can enhance their applications with advanced AI capabilities, automate tasks, and improve user experiences.

# Test API

```bash
curl --location 'http://localhost:8080/api/v1/chat' \
--header 'Content-Type: application/json' \
--data '{"question":"Hello there?"}'
'


Spring boot integration of ChatGPT api

# Output
{
    "id": "chatcmpl-7GVV9uhSU82zoOr2GCWrIlb5dWaWZ",
    "object": "chat.completion",
    "model": "gpt-3.5-turbo-0301",
    "created": "+4679311-07-30",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "Hello, how can i assist you today?"
            }
        }
    ],
    "usage": {
        "prompt_tokens": "19",
        "completion_tokens": "22",
        "total_tokens": "41"
    }
}
```


This output provides details such as the completion ID, the model used, the timestamp of creation, the message, and token usage statistics.

Ensure that your Spring Boot application is correctly configured to handle requests to http://localhost:8080/api/v1/chat with the appropriate JSON payload containing the question to be processed.