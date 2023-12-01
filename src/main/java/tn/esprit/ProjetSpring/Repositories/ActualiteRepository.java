package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Actualite;

public interface ActualiteRepository extends JpaRepository<Actualite,Long> {
}
