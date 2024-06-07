package com.example.Control.Service;


import com.example.Control.Model.Projet;
import com.example.Control.Repository.ProjectJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectJpaRepo projectRepository;

    public List<Projet> getAllProjects() {
        return projectRepository.findAll();
    }

    public Projet createNewProject(Projet Projet) {
        return projectRepository.save(Projet);
    }

    public void deleteProject(long projectId) {
        projectRepository.deleteById(projectId);
    }

    public Optional<Projet> getProjectById(long projectId) {
        return projectRepository.findById(projectId);
    }
}
