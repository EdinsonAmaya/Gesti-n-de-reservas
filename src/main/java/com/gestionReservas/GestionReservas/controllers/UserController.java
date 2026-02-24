package com.gestionReservas.GestionReservas.controllers;

import com.gestionReservas.GestionReservas.dto.UserDTO;
import com.gestionReservas.GestionReservas.dto.UserRegistrationDTO;
import com.gestionReservas.GestionReservas.models.Users;
import com.gestionReservas.GestionReservas.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<UserDTO> listUsers(){
        return usersService.listUsers();
    }

    @GetMapping("/{id}")
    public UserDTO listUser(@PathVariable Long id){
        return usersService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserRegistrationDTO user){
        return usersService.createUser(user);
    }

}
