package com.GestionDesProjets.GestionDeProjet.Controllers;

import com.GestionDesProjets.GestionDeProjet.Models.Project;
import com.GestionDesProjets.GestionDeProjet.Models.Resource;
import com.GestionDesProjets.GestionDeProjet.Models.Task;
import com.GestionDesProjets.GestionDeProjet.Models.User;
import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import com.GestionDesProjets.GestionDeProjet.Services.ResourceService;
import com.GestionDesProjets.GestionDeProjet.Services.TaskService;
import com.GestionDesProjets.GestionDeProjet.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DashboardController {

    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    /*----------------------Home Page-------------------------*/

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/check")
    public String checkLogin(@RequestParam("email") String email,
                             @RequestParam("password") String password,
                             HttpSession session,
                             Model model) {
        User user = userService.checkLogin(email, password);
        if (user != null) {
            session.setAttribute("userId", user.getId());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*----------------------Dashboard-------------------------*/

    @GetMapping("/dashboard")
    public String dashboard(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size,
            HttpSession session,
            Model model) {

        int userId = (int) session.getAttribute("userId");
        model.addAttribute("user", userService.findById(userId));

        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projectPage = projectService.getAllProjectsByUserId(userId, pageable);

        model.addAttribute("projects" , projectService.getAllProjectsForId());
        model.addAttribute("projectPage", projectPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);

        return "dashboard";
    }

    @PostMapping("/addProject")
    public String addProject(@ModelAttribute Project project, HttpSession session) {

        int userId = (int) session.getAttribute("userId");
        User user = new User();

        user.setId(userId);
        project.setUser(user);
        projectService.saveProject(project);

        return "redirect:/dashboard";
    }


    @PostMapping("/UpdateProject")
    public String updateProject(Model model, Project project, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        model.addAttribute("project", project);
        projectService.updateProject(project.getId(), project);
        int projectId = project.getId();
        return "redirect:/showProject?id=" + projectId;
    }

    @GetMapping("/showProject")
    public String showProject(@RequestParam("id") int id, Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Project project = projectService.findTaskByProject_Id(id);

        model.addAttribute("Oneproject", project);
        model.addAttribute("projects", projectService.getAllProjectsForId());
        List<Task> tasks = taskService.getTaskByProjectId(id);
        model.addAttribute("tasks", tasks);
        return "dashProject";
    }

    @GetMapping("/deleteProject")
    public String deleteProject(@RequestParam("id") int id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        projectService.deleteProject(id);
        return "redirect:/dashboard";
    }

    /*---------------------Tasks Crud--------------------------*/

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") int taskId, @RequestParam("idP") int projectId, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        taskService.deleteTask(taskId);
        return "redirect:/showProject?id=" + projectId;
    }

    @PostMapping("/AddTask")
    public String addTask(@ModelAttribute Task task, @RequestParam("projectId") int projectId, Model model) {
        Project project = new Project();
        project.setId(projectId);
        task.setProject(project);
        taskService.saveTask(task);
        return "redirect:/showProject?id=" + projectId;
    }


    /*---------------------User Crud--------------------------*/

    @PostMapping("/addUser")
    public String addUser(User user, Model model, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        userService.save(user);
        model.addAttribute("userMessage", "Welcome to your account");
        System.out.println("new User ------ > " + user);
        return "redirect:/dashboard";
    }

    /*---------------------Resource Crud--------------------------*/

    @GetMapping("/showResource")
    public String showResource(@RequestParam("id") int projectId, @RequestParam("idT") int taskId, HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }
        List<Resource> resources = resourceService.findByTaskId(taskId);
        model.addAttribute("Resources", resources);
        Project project = projectService.findTaskByProject_Id(projectId);

        model.addAttribute("Oneproject", project);
        model.addAttribute("projects", projectService.getAllProjectsForId());
        List<Task> tasks = taskService.getTaskByProjectId(projectId);
        model.addAttribute("tasks", tasks);
        return "dashProject";

    }


    /*--------------------- Logout --------------------------*/

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        return "redirect:/login";
    }
}
