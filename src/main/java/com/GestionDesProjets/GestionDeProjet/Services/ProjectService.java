package com.GestionDesProjets.GestionDeProjet.Services;
import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    public Project getProjectById(int id) {
        return projectRepository.findById(id).orElseThrow();
    }
    public void addProject(Project project) {
        projectRepository.save(project);
    }
    public void updateProject(Project project) {
        projectRepository.save(project);
    }
    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }
}
