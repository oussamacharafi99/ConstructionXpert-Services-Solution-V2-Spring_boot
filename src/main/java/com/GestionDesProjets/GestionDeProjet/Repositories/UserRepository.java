package com.GestionDesProjets.GestionDeProjet.Repositories;
import com.GestionDesProjets.GestionDeProjet.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
}

