package com.example.Control.Controller;

import com.example.Control.Model.Projet;
import com.example.Control.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projets")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Projet> getAllProjets() {
        return projectService.getAllProjects();
    }

    @PostMapping
    @PreAuthorize("hasRole('MANAGER') or hasRole('TECH_LEAD')")
    public Projet createProjet(@RequestBody Projet projet) {
        return projectService.createNewProject(projet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Optional<Projet> projet = projectService.getProjectById(id);
        return projet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER') or hasRole('TECH_LEAD')")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        Optional<Projet> projet = projectService.getProjectById(id);
        if (projet.isPresent()) {
            projectService.deleteProject(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MANAGER') or hasRole('TECH_LEAD')")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projetDetails) {
        Optional<Projet> projet = projectService.getProjectById(id);
        if (projet.isPresent()) {
            Projet updatedProjet = projet.get();
            updatedProjet.setName(projetDetails.getName());
            updatedProjet.setBudget(projetDetails.getBudget());
            projectService.createNewProject(updatedProjet);
            return ResponseEntity.ok(updatedProjet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
