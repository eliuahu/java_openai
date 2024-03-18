package com.example.spring.boot.chatgpt.controller;

import com.example.spring.boot.chatgpt.model.entity.SpecificationEntity;
import com.example.spring.boot.chatgpt.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specifications")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("/all")
    public List<SpecificationEntity> findAll() {
        return specificationService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<SpecificationEntity> findById(@PathVariable Long id) {
        return specificationService.findById(id);
    }

    @PostMapping("/create")
    public SpecificationEntity save(@RequestBody SpecificationEntity specificationEntity) {
        return specificationService.save(specificationEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        specificationService.deleteById(id);
    }
}
