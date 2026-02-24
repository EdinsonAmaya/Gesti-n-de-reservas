package com.gestionReservas.GestionReservas.services;

import com.gestionReservas.GestionReservas.dto.ReservationDTO;
import com.gestionReservas.GestionReservas.dto.ReservationRequestDTO;
import com.gestionReservas.GestionReservas.exceptions.ResourceAlreadyBookedException;
import com.gestionReservas.GestionReservas.models.Reservation;
import com.gestionReservas.GestionReservas.repositories.ReservationRepository;
import com.gestionReservas.GestionReservas.repositories.ResourceRepository;
import com.gestionReservas.GestionReservas.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    private LocalDateTime today = LocalDateTime.now();

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ReservationDTO> listReservation(){
        List<Reservation> reservationsList = reservationRepository.findAll();

        return reservationsList.stream().map(this::convertReservetionDTO).toList();
    }

    public List<ReservationDTO> findByUser_Name(String userName){

        if (userName == null || userName.isEmpty()){
            throw new RuntimeException("No se encuentra un nombre valido");
        }
        List<Reservation> reservationsList = reservationRepository.findByUser_Name(userName);

        return reservationsList.stream().map(this::convertReservetionDTO).toList();
    }

    public ReservationDTO findById(Long id){

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro la reserva con el ID: "+id));

        return convertReservetionDTO(reservation);
    }

    public void deleteResource(Long id){
        reservationRepository.deleteById(id);
    }

    public ReservationDTO createReservation(ReservationRequestDTO newReservation){

        if (newReservation.getStartDate().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Fecha de comienzo no valida");
        }
        if (!newReservation.getEndDate().isAfter(newReservation.getStartDate())){
            throw new RuntimeException("Fecha de salida no valida");
        }

        boolean isOccupied = reservationRepository.existsOverlappingReservation(
                newReservation.getResourceId(),
                newReservation.getStartDate(),
                newReservation.getEndDate()
        );

        if (isOccupied){
            throw new ResourceAlreadyBookedException("El resource ya se encuentra ocupado en este horario.");
        }

        Reservation reservation = new Reservation();
        reservation.setUser(usersRepository.findById(newReservation.getUserId())
                .orElseThrow(()-> new RuntimeException("No se encontro el usuario con el id solicitado")));
        reservation.setResource(resourceRepository.findById(newReservation.getResourceId())
                .orElseThrow(()-> new RuntimeException("No se encontro el recurso con el id solicitado")));
        reservation.setStartDate(newReservation.getStartDate());
        reservation.setEndDate(newReservation.getEndDate());

        return convertReservetionDTO(reservationRepository.save(reservation));
    }

    private ReservationDTO convertReservetionDTO(Reservation reservation){
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setResourceName(reservation.getResource().getName());
        dto.setUserName(reservation.getUser().getName());
        dto.setStartDate(reservation.getStartDate());
        dto.setEndDate(reservation.getEndDate());

        return dto;
    }

}
