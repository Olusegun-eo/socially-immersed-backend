package com.emmanueljohnsnbruna.Blackbrowncommunity.service;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Resource;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResourceService {

    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public Resource createResource(Resource resource) {
        resourceRepository.save(resource);
        return resource;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

}

