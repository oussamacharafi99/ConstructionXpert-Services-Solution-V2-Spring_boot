package com.GestionDesProjets.GestionDeProjet.Services;
import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    public Page<Project> getAllProjects(Pageable pageable) {
//        return projectRepository.findAll(pageable);
//    }

    public Page<Project> getAllProjectsByUserId(int userId, Pageable pageable) {
        return projectRepository.findByUserId(userId, pageable);
    }
    public List<Project> getAllProjectsForId() {
        return projectRepository.findAll();
    }

    public Project findTaskByProject_Id(Integer id) {
        return projectRepository.findById(id).orElseThrow();
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(Integer id, Project project) {
        return projectRepository.save(project);
    }

}
