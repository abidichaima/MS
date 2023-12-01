package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Evenement;

import java.util.List;

public interface IEvenementService {
    Evenement addEvenement (Evenement evenement);

    Evenement getEvenement(Long IdEvenement);

    List<Evenement> getAllEvenements();

    Void deleteBy (Long IdEvenement);

    Evenement updateEvenement (Evenement evenement);
}

