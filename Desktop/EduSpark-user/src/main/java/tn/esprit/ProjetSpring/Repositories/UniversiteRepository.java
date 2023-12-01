package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
