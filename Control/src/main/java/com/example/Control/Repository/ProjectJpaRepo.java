package com.example.Control.Repository;

    import com.example.Control.Model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepo extends JpaRepository<Projet,Long> {
    Projet findAllBy(String username);
}
