package com.devtrack.backend.service;

import com.devtrack.backend.entity.Project;
import com.devtrack.backend.repository.ProjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() { return projectRepository.findAll(); }
    public Project findById(Long id) { return projectRepository.findById(id).orElseThrow(); }
    public Project save(Project project) { return projectRepository.save(project); }
}