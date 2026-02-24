package com.gestionReservas.GestionReservas.controllers;

import com.gestionReservas.GestionReservas.dto.ReservationDTO;
import com.gestionReservas.GestionReservas.dto.ReservationRequestDTO;
import com.gestionReservas.GestionReservas.models.Reservation;
import com.gestionReservas.GestionReservas.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationDTO> listReservations(){
        return reservationService.listReservation();
    }

    @GetMapping("/{id}")
    public ReservationDTO listReservation(@PathVariable Long id){
        return reservationService.findById(id);
    }

    @GetMapping("/{userName}")
    public List<ReservationDTO> findByUsername(@PathVariable String userName){
        return reservationService.findByUser_Name(userName);
    }

    @DeleteMapping("/{id}")
    public void deletedReservarion(@PathVariable Long id){
        reservationService.deleteResource(id);
    }

    @PostMapping
    public ReservationDTO createReservation(@RequestBody ReservationRequestDTO reservation){
        return reservationService.createReservation(reservation);
    }

}

