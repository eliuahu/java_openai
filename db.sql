CREATE TABLE chat_gpt_response (
                                   id VARCHAR(255) PRIMARY KEY,
                                   object VARCHAR(255),
                                   model VARCHAR(255),
                                   created DATE
);

CREATE TABLE specification (
                               id SERIAL PRIMARY KEY,
                               description VARCHAR(255)
);

CREATE TABLE chat_gpt_response_specification (
                                                 chat_gpt_response_id VARCHAR(255) REFERENCES chat_gpt_response(id),
                                                 specification_id INTEGER REFERENCES specification(id),
                                                 PRIMARY KEY (chat_gpt_response_id, specification_id)
);

CREATE TABLE source (
                        id SERIAL PRIMARY KEY,
                        url VARCHAR(255) NOT NULL,
                        chat_gpt_response_id VARCHAR(255) REFERENCES chat_gpt_response(id),
                        FOREIGN KEY (chat_gpt_response_id) REFERENCES chat_gpt_response(id)
);
