package com.GestionDesProjets.GestionDeProjet.Services;

import com.GestionDesProjets.GestionDeProjet.Models.Task;
import com.GestionDesProjets.GestionDeProjet.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTaskByProjectId(Integer projectId) {
        return taskRepository.findTaskByProject_Id(projectId);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
