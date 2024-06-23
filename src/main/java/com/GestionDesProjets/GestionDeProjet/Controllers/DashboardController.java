package com.GestionDesProjets.GestionDeProjet.Controllers;

import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Models.Task;
import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import com.GestionDesProjets.GestionDeProjet.Services.ResourceService;
import com.GestionDesProjets.GestionDeProjet.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Controller
public class DashboardController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResourceService resourceService;


    @RequestMapping("/")
    public String index() {
        return "index";
    }

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
    public String addProject(Model model , Project project) {
        projectService.saveProject(project);
        return "redirect:/dashboard";
    }
    @PostMapping("/UdateProject")
    public String updateProject(Model model, Project project) {
        model.addAttribute("project", project);
        projectService.updateProject(project.getId(), project);
        return "redirect:/dashboard";
    }

    ////

    @GetMapping("/showProject")
    public String showProject(@RequestParam("id") int id, Model model) {

        Project project = projectService.getProjectById(id);

        model.addAttribute("Oneproject", project);
        model.addAttribute("projects", projectService.getAllProjectsForId());
        List<Task> tasks = taskService.getTaskByProjectId(id);
        model.addAttribute("tasks", tasks);

        return "dashProject";
    }

    @GetMapping("/DeleteProject")
    public String deleteProject(@RequestParam("id") int id, Model model) {
        projectService.deleteProject(id);
        return "redirect:/dashboard";
    }

//    @RequestMapping("/dashProject")
//    public String dashProject(Model model) {
//        return "dashProject";
//    }


    //////task zone /////
    @GetMapping("/DeleteTask")
    public String deleteTask(@RequestParam("id") int taskId, @RequestParam("idP") int projectId, Model model) {
        taskService.deleteTask(taskId);
        return "redirect:/showProject?id=" + projectId;
    }

}

