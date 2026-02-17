package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ProjectDTO;
import entity.Project;
import repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Fetch all projects and map Entity -> DTO
    public List<ProjectDTO> getAllProjects() {

        List<Project> projects = projectRepository.findAll();

        return projects.stream()
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
