package com.gestionReservas.GestionReservas.services;

import com.gestionReservas.GestionReservas.models.Resource;
import com.gestionReservas.GestionReservas.repositories.ResourceRepository;
import com.gestionReservas.GestionReservas.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    private List<String> allTypes = Arrays.asList("ESCRITORIO","SALA", "CABINA");

    public List<Resource> listResorce(){
        return resourceRepository.findAll();
    }

    public Resource findById(Long id){
        return resourceRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro un resource con el id: "+ id));
    }

    public void deleteResource(Long id){
        resourceRepository.deleteById(id);
    }

    public Resource createResource(Resource resource){

        if (resource.getCapacity() == null){
            throw new RuntimeException("El resource debe tener definida una capacidad");
        }
        if (resource.getType() == null || resource.getType().isEmpty() || !allTypes.contains(resource.getType())){
            throw new RuntimeException("El resource debe tener definido un tipo");
        }
        if (resource.getName() == null || resource.getName().isEmpty()){
            throw new RuntimeException("El resource debe tener definido un nombre");
        }

        return resourceRepository.save(resource);
    }

}
