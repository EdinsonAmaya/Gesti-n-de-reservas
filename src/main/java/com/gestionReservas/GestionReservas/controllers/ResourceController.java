package com.gestionReservas.GestionReservas.controllers;

import com.gestionReservas.GestionReservas.models.Resource;
import com.gestionReservas.GestionReservas.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public List<Resource> listResources(){
        return resourceService.listResorce();
    }

    @GetMapping("/{id}")
    public Resource listResource(@PathVariable Long id){
        return resourceService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletedResource(@PathVariable Long id){
        resourceService.deleteResource(id);
    }

    @PostMapping
    public Resource createResource(@RequestBody Resource resource){
        return resourceService.createResource(resource);
    }
}
