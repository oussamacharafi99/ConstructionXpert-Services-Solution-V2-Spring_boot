package com.GestionDesProjets.GestionDeProjet.Repositories;

import com.GestionDesProjets.GestionDeProjet.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}