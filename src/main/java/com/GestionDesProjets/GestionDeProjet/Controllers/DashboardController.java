package com.GestionDesProjets.GestionDeProjet.Controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import com.GestionDesProjets.GestionDeProjet.Services.ResourceService;
import com.GestionDesProjets.GestionDeProjet.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    ProjectService projectService;
    @Autowired
    TaskService taskService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/dashboard")
    public String dashboard(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        httpSession.setAttribute("user" , projects.get(0));
        return "dashboard";
    }

}
