package com.example.spring.boot.chatgpt.controller;

import com.example.spring.boot.chatgpt.model.entity.SourceEntity;
import com.example.spring.boot.chatgpt.service.SourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/sources")
public class SourceController {
    private final SourceService sourceService;

    public SourceController(SourceService sourceService) {
        this.sourceService = sourceService;
    }

    @PostMapping("/link/{chatGPTResponseId}")
    public ResponseEntity<?> addSourcesToChatGPTResponse(@RequestBody List<SourceEntity> sources, @PathVariable String chatGPTResponseId) {
        sourceService.addSourcesToChatGPTResponse(chatGPTResponseId, sources);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<SourceEntity>> getAllSources() {
        List<SourceEntity> sources = sourceService.findAll();
        return new ResponseEntity<>(sources, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SourceEntity> getSourceById(@PathVariable Long id) {
        Optional<SourceEntity> sourceOptional = sourceService.findById(id);
        if (sourceOptional.isPresent()) {
            return new ResponseEntity<>(sourceOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<SourceEntity> updateSource(@PathVariable Long id, @RequestBody SourceEntity sourceDetails) {
        Optional<SourceEntity> sourceOptional = sourceService.findById(id);
        if (sourceOptional.isPresent()) {
            SourceEntity source = sourceOptional.get();
            source.setUrl(sourceDetails.getUrl());
            SourceEntity updatedSource = sourceService.save(source);
            return new ResponseEntity<>(updatedSource, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSource(@PathVariable Long id) {
        if (sourceService.findById(id).isPresent()) {
            sourceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
