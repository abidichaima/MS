package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    Universite getUniversite(Long id);
    List<Universite> getAllUniversites();
    void deleteUniversite(long idUniversite);
    Universite updateUniversite(Universite universite);
}
