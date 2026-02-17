package com.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.dto.ProjectDTO;
import com.portfolio.entity.Project;
import com.portfolio.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Create Project from DTO
    public ProjectDTO createProject(ProjectDTO dto) {

        Project project = new Project();
        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setThumbnailUrl(dto.getThumbnailUrl());
        project.setLiveDemoUrl(dto.getLiveDemoUrl());
        project.setSourceCodeUrl(dto.getSourceCodeUrl());

        Project saved = projectRepository.save(project);

        dto.setId(saved.getId());
        return dto;
    }

    // Fetch all projects
    public List<ProjectDTO> getAllProjects() {

        return projectRepository.findAll()
                .stream()
                .map(project -> {
                    ProjectDTO dto = new ProjectDTO();
                    dto.setId(project.getId());
                    dto.setTitle(project.getTitle());
                    dto.setDescription(project.getDescription());
                    dto.setThumbnailUrl(project.getThumbnailUrl());
                    dto.setLiveDemoUrl(project.getLiveDemoUrl());
                    dto.setSourceCodeUrl(project.getSourceCodeUrl());

                    if (project.getClient() != null) {
                        dto.setClientId(project.getClient().getId());
                        dto.setClientName(project.getClient().getName());
                    }

                    return dto;
                })
                .collect(Collectors.toList());
    }
}