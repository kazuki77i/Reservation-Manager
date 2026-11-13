package com.kazuki.reservation.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kazuki.reservation.service.ReservationService;
import com.kazuki.reservation.entity.Reservation;

import java.util.List;


@RestController

public class ReservationController {

    private final ReservationService service;

    public ReservationController(
        ReservationService service) {

        this.service = service;
    }

    @GetMapping("/reservations")
   public List<Reservation> getAllReservations() {
        // ここで全ての予約を取得するロジックを実装
        return service.getAllReservations();
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservationById(
        @PathVariable int id) {
        // ここでIDに基づいて予約を取得するロジックを実装
        return service.getReservationById(id); 
    }

@PostMapping("/reservations")
    public Reservation create(
        @RequestBody Reservation reservation) {
        // ここで予約を作成するロジックを実装
        
        return service.createReservation(
            reservation);
    }

 @PutMapping("/reservations/{id}")
    public String updateReservation(
        @PathVariable int id, 
        @RequestBody Reservation updatedReservation) {
        // ここで予約を更新するロジックを実装
       
        return service.updateReservation(
            id,  updatedReservation);
        
    }

@DeleteMapping("/reservations/{id}")
    public String deleteReservation(
        @PathVariable int id) {
        // ここで予約を削除するロジックを実装
        return service.deleteReservation(id);
       
}

}