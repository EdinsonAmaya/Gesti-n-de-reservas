package com.gestionReservas.GestionReservas.services;

import com.gestionReservas.GestionReservas.dto.UserDTO;
import com.gestionReservas.GestionReservas.dto.UserRegistrationDTO;
import com.gestionReservas.GestionReservas.models.Users;
import com.gestionReservas.GestionReservas.repositories.UsersRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<UserDTO> listUsers(){
        List<Users> users = usersRepository.findAll();

        return users.stream().map(this::convertUserDTO).toList();

    }

    public UserDTO findById(Long id){
        Users user = usersRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("No se encontro el usuario con el ID "+ id));

        return convertUserDTO(user);
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }

    public UserDTO createUser(UserRegistrationDTO user){

        Users userRegister = new Users();
        userRegister.setName(user.getName());
        userRegister.setEmail(user.getEmail());
        userRegister.setPassword(user.getPassword());
        userRegister.setIsAdmin(false);

        return convertUserDTO(usersRepository.save(userRegister));

    }

    private UserDTO convertUserDTO(Users user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
