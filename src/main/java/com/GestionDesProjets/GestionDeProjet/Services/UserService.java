package com.GestionDesProjets.GestionDeProjet.Services;

import com.GestionDesProjets.GestionDeProjet.Models.User;
import com.GestionDesProjets.GestionDeProjet.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }
    public void save(User user) {
        userRepository.save(user);
    }
    public void delete(User user) {
        userRepository.delete(user);
    }
    public void update(User user) {
        userRepository.save(user);
    }

    public User checkLogin(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
