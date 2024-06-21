package com.GestionDesProjets.GestionDeProjet.Repositories;
import com.GestionDesProjets.GestionDeProjet.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
