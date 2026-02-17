package com.portfolio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.ProjectDTO;
import com.portfolio.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200") // Angular Admin
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // ✅ GET ALL PROJECTS
    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        List<ProjectDTO> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    // ✅ CREATE PROJECT
    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO dto) {
        ProjectDTO saved = projectService.createProject(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // ✅ UPDATE PROJECT
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(
            @PathVariable Long id,
            @RequestBody ProjectDTO dto) {

        dto.setId(id);
        ProjectDTO updated = projectService.createProject(dto);
        return ResponseEntity.ok(updated);
    }


}