package com.GestionDesProjets.GestionDeProjet.Controllers;

import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
