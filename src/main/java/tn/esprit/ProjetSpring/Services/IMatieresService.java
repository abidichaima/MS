package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Matieres;

import java.util.List;

public interface IMatieresService {
    Matieres addMatiere(Matieres matieres);
    Matieres getMatiereById(Integer id);
    List<Matieres> getAllMatieres();
    Matieres updateMatiere(Matieres matieres);
    void deleteMatiere(Integer id);
}

