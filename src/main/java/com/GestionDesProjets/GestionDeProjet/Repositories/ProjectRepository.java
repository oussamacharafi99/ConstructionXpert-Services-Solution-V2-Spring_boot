package com.GestionDesProjets.GestionDeProjet.Repositories;
import com.GestionDesProjets.GestionDeProjet.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p FROM Project p WHERE p.id = :id")
    Project findProjectBy(@Param("id") Integer id);
}
