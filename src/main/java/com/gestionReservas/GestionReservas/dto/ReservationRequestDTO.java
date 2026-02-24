package com.gestionReservas.GestionReservas.dto;

import com.gestionReservas.GestionReservas.models.Resource;
import com.gestionReservas.GestionReservas.models.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
public class ReservationRequestDTO {

    @NotNull
    private Long userId;
    @NotNull
    private Long resourceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
