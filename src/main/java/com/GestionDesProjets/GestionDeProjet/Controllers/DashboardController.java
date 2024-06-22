package com.GestionDesProjets.GestionDeProjet.Controllers;

import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import com.GestionDesProjets.GestionDeProjet.Services.ResourceService;
import com.GestionDesProjets.GestionDeProjet.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DashboardController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResourceService resourceService;


    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projectPage = projectService.getAllProjects(pageable);

        model.addAttribute("projectPage", projectPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("projects", projectService.getAllProjectsForId());

        return "dashboard";
    }
    @RequestMapping("/addProject")
    public String addProject(ch.qos.logback.core.model.Model model , Project project) {
        projectService.saveProject(project);
        return "redirect:/dashboard";
    }
}
