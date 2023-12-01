package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Plat;

import java.util.List;

public interface IPlatService {
    Plat addPlat(Plat plat);

    Plat getPlatByid(Long id);

    List<Plat> getAllPlats();

    void deletePlat(long idPlat);

    Plat updatePlat(Plat plat);
}
