package com.gestionReservas.GestionReservas.repositories;

import com.gestionReservas.GestionReservas.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
