package com.emmanueljohnsnbruna.Blackbrowncommunity.web;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Resource;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getResourceById(@PathVariable Long id) {
        Resource resource = resourceService.getResourceById(id);
        if (resource != null) {
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Resource> createResource(@RequestBody Resource resource) {
        Resource createdResource = resourceService.createResource(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource> updateResource(@PathVariable Long id, @RequestBody Resource resource) {
        Resource updatedResource = resourceService.updateResource(id, resource);
        if (updatedResource != null) {
            return ResponseEntity.ok(updatedResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resource> deleteResource(@PathVariable Long id) {
        boolean isDeleted = resourceService.deleteResource(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/{label}")
    public List<Resource> searchResourcesByLabel(@PathVariable String label) {
        return resourceService.searchResourcesByLabel(label);
    }
}

