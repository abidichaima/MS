package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Actualite;
import tn.esprit.ProjetSpring.entities.Bloc;

import java.util.List;

public interface IActualiteService {
    Actualite addActualite(Actualite actualite);

    Actualite getActualite(Long id);

    List<Actualite> getAllActualites();

    void deleteActualite(long idActualite);

    Actualite updateActualite(Actualite actualite);
}
