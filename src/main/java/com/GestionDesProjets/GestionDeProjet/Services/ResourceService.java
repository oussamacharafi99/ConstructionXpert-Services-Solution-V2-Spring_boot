package com.GestionDesProjets.GestionDeProjet.Services;

import com.GestionDesProjets.GestionDeProjet.Models.Resource;
import com.GestionDesProjets.GestionDeProjet.Repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Optional<Resource> findAllResourceByIdTask(Integer id) {
        return resourceRepository.findById(id);
    }

    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }
    public void deleteResource(Resource resource) {
        resourceRepository.delete(resource);
    }
    public void deleteResourceById(Integer id) {
        resourceRepository.deleteById(id);
    }

}
