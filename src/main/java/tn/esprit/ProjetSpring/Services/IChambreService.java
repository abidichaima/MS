package tn.esprit.ProjetSpring.Services;


import tn.esprit.ProjetSpring.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre chambre);
    Chambre getChambre(Long id);
    List<Chambre> getAllChambres();
    void deleteChambre(long idChambre);
    Chambre updateChambre(Chambre chambre);
}
