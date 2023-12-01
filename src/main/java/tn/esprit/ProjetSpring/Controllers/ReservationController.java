package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IReservationService;
import tn.esprit.ProjetSpring.entities.Reservation;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationController {
    IReservationService reservationService;

    @PostMapping("/addreservation")
    Reservation addReservation (@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/reservation/{id}")
    Reservation retrieveReservation(@PathVariable long id){

        return reservationService.getReservation(id);
    }

    @GetMapping("/reservations")
    List<Reservation> retrieveReservation(Reservation reservation){

        return reservationService.getAllReservations();
    }


    @PutMapping("/reservation")
    Reservation updateReservation (@RequestBody Reservation reservation)
    {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/reservation/{id}")
    void deleteReservation(@PathVariable long id){

        reservationService.deleteReservation(id);
    }
}
