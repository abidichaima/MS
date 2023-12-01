package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.ReservationRepository;
import tn.esprit.ProjetSpring.entities.Reservation;

import java.util.List;
@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{

    ReservationRepository reservationRepository;



    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation res=reservationRepository.findById(reservation.getIdReservation()).orElse(null);
        if (res!=null)
            reservationRepository.save(reservation);
        return  res;
    }
}
