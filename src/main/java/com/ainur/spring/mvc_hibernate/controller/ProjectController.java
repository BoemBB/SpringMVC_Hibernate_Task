package com.ainur.spring.mvc_hibernate.controller;

import com.ainur.spring.mvc_hibernate.entity.Project;
import com.ainur.spring.mvc_hibernate.execption_handling.NoSuchEmployeeException;
import com.ainur.spring.mvc_hibernate.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> showAllEmployees(){
        List<Project> allProjects = projectService.getAllProjects();

        return allProjects;
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id){
        Project project = projectService.getProject(id);

        if(project == null){
            throw new NoSuchEmployeeException("there is no project with this id " + id);
        }
        return project;
    }

    @PostMapping("/projects")
    public Project addNewProject(@RequestBody Project project){
        projectService.saveProject(project);
        return project;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project){
        projectService.saveProject(project);
        return project;
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id){
        Project project = projectService.getProject(id);
        if (project == null){
            throw new NoSuchEmployeeException("there is no project with id " + id);
        }
        projectService.deleteProject(id);
        return "project " + id + "was deleted";
    }
}
