package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation getReservation(long id);
    List<Reservation> getAllReservations();
    void deleteReservation(long idReservation);
    Reservation updateReservation(Reservation reservation);
}
