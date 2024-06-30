package com.GestionDesProjets.GestionDeProjet.Repositories;
import com.GestionDesProjets.GestionDeProjet.Models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    List<Resource> findByTask_Id(int id);
}
