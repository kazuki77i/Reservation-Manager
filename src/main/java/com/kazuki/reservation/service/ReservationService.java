package com.kazuki.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kazuki.reservation.entity.Reservation;
import com.kazuki.reservation.exception.ResourceNotFoundException;
import com.kazuki.reservation.repository.ReservationRepository;


@Service
public class ReservationService {

private final ReservationRepository repository;

public ReservationService(
        ReservationRepository repository) {

    this.repository = repository;
}

public List<Reservation> getAllReservations() {
    return repository.findAll();
}

public Reservation getReservationById(int id) {
    return repository.findById(id)
        .orElseThrow(() -> 
            new ResourceNotFoundException(
            " 予約ID " + id + " が見つかりませんでした "));
     
}

public String updateReservation(
    int id, Reservation updatedReservation) {

    Reservation reservation = 
    repository.findById(id)
        .orElseThrow(() ->
        new ResourceNotFoundException(
        " 予約ID " + id + " が見つかりませんでした "));

    reservation.setName(updatedReservation.getName());
    reservation.setDate(updatedReservation.getDate());
    repository.save(reservation);
    return "予約が更新されました: " + id;
        
    }


public Reservation createReservation(
    Reservation reservation) {

    return repository.save(reservation);
}

public String deleteReservation(int id) {
    Reservation reservation =
    repository.findById(id)
        .orElseThrow(() -> 
            new ResourceNotFoundException(
            " 予約ID " + id + " が見つかりませんでした "));
    repository.delete(reservation);
    return "予約が削除されました: " + id;
}
}