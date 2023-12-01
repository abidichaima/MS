package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Niveau;

import java.util.List;

public interface INiveauService {
    Niveau addNiveau(Niveau niveau);
    Niveau getNiveauById(Long id);
    List<Niveau> getAllNiveau();
    Niveau updateNiveau(Niveau niveau);
    void deleteNiveau(Long id);
}

