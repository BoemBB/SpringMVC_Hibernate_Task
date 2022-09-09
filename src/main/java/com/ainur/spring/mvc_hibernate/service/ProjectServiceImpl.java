package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.dao.ProjectDao;
import com.ainur.spring.mvc_hibernate.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectDao projectDao;

    @Override
    @Transactional
    public List<Project> getAllProjects() {
        return projectDao.getAllProjects();
    }

    @Override
    @Transactional
    public void saveProject(Project project) {
        projectDao.saveProject(project);
    }

    @Override
    @Transactional
    public Project getProject(int id) {
        return projectDao.getProject(id);
    }

    @Override
    @Transactional
    public void deleteProject(int id) {
        projectDao.deleteProject(id);
    }
}
