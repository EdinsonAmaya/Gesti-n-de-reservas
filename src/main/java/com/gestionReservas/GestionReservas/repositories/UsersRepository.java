package com.gestionReservas.GestionReservas.repositories;

import com.gestionReservas.GestionReservas.dto.UserDTO;
import com.gestionReservas.GestionReservas.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
