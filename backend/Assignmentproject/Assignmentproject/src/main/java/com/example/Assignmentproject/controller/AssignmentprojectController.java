package com.example.Assignmentproject.controller;

import com.example.Assignmentproject.dto.AssignmentprojectDto;
import com.example.Assignmentproject.entity.AssignmentprojectEntity;
import com.example.Assignmentproject.service.AssignmentprojectService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5174")
public class AssignmentprojectController {

    @Autowired
    private AssignmentprojectService service;

    @PostMapping("/create")
    public ResponseEntity<AssignmentprojectEntity> createUser(@Valid @RequestBody AssignmentprojectDto dto) {
        return ResponseEntity.ok(service.createUser(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssignmentprojectEntity>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AssignmentprojectEntity> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AssignmentprojectEntity> updateUser(
            @PathVariable String id,
            @Validated @RequestBody AssignmentprojectDto dto) {
        return ResponseEntity.ok(service.updateUser(id, dto));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        service.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
