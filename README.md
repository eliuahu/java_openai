# Spring Boot Integration APIs of OpenAI

## Requirements

1. Java - 17
2. Maven - 3.x.x > 

## Test API

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

