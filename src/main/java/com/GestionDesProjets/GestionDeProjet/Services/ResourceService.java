package com.GestionDesProjets.GestionDeProjet.Services;

import com.GestionDesProjets.GestionDeProjet.Models.Resource;
import com.GestionDesProjets.GestionDeProjet.Repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;
    public List<Resource> findByTaskId(int id) {
        return resourceRepository.findByTask_Id(id);
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
