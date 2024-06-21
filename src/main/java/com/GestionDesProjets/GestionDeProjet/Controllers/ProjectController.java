package com.GestionDesProjets.GestionDeProjet.Controllers;

import com.GestionDesProjets.GestionDeProjet.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
