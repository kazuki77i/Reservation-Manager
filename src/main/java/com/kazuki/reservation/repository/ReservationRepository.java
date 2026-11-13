package com.kazuki.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kazuki.reservation.entity.Reservation;

public interface ReservationRepository extends
 JpaRepository<Reservation, Integer> {
    
}