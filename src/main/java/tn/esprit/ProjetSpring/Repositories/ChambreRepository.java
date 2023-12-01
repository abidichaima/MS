package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    Chambre findByNumeroChambre(Long num);
}
