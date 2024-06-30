package com.GestionDesProjets.GestionDeProjet.Repositories;

import com.GestionDesProjets.GestionDeProjet.Models.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Project findById(int id);
    Page<Project> findByUserId(int userId, Pageable pageable);
    List<Project> findProjectByUser_Id(int userId);
}
