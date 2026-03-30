package com.kazuki.reservation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
    
@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}

@DeleteMapping("/reservations/{id}")
public String deleteReservation(@PathVariable int id) {
	// ここで予約を削除するロジックを実装
	boolean removed = reservations.removeIf(
		reservation -> reservation.getId() == id
	);
	
	if (removed) {
		return "予約が削除されました: " + id;
	} else {
		return "予約が見つかりませんでした: " + id;
	}
}

@PutMapping("/reservations/{id}")
public String updateReservation(@PathVariable int id, @RequestBody Reservation updatedReservation) {
    // ここで予約を更新するロジックを実装
    for (Reservation reservation : reservations) {
        if (reservation.getId() == id) {
            reservation.setName(updatedReservation.getName());
            reservation.setDate(updatedReservation.getDate());
            return "予約が更新されました: " + id;
        }
    }
    return "予約が見つかりませんでした: " + id;
}