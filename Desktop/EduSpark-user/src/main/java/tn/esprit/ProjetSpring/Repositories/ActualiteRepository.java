package tn.esprit.ProjetSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.ProjetSpring.entities.Actualite;
import tn.esprit.ProjetSpring.entities.VerificationToken;

public interface ActualiteRepository extends JpaRepository<Actualite,Long> {
    interface verificationTokenRepository extends JpaRepository<VerificationToken,Long > {
    }
}
