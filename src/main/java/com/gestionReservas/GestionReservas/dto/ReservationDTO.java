package com.gestionReservas.GestionReservas.dto;

import com.gestionReservas.GestionReservas.models.Resource;
import com.gestionReservas.GestionReservas.models.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO {

    private Long id;
    private String userName;
    private String resourceName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
