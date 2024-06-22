package com.GestionDesProjets.GestionDeProjet.Services;

import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Page<Project> getAllProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
    public List<Project> getAllProjectsForId() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}
