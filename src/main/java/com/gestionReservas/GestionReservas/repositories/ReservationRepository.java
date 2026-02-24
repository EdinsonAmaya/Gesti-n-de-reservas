package com.gestionReservas.GestionReservas.repositories;

import com.gestionReservas.GestionReservas.models.Reservation;
import com.gestionReservas.GestionReservas.models.Resource;
import com.gestionReservas.GestionReservas.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUser_Name(String userName);

    @Query("SELECT COUNT(r) > 0 FROM Reservation r WHERE r.resource.id = :resourceId " + " AND (:start < r.endDate AND :end > r.startDate) ")
    boolean existsOverlappingReservation(
            @Param("resourceId") Long resourceId,
            @Param("start")LocalDateTime start,
            @Param("end")LocalDateTime end
            );

}
