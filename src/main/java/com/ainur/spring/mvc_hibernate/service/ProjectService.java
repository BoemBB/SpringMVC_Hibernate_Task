package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    void saveProject(Project project);

    Project getProject(int id);

    void deleteProject(int id);
}
