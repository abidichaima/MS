package tn.esprit.ProjetSpring.Services;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.EvenementRepository;
import tn.esprit.ProjetSpring.entities.Evenement;

import java.util.List;

@Service
@AllArgsConstructor
public class EvenementService implements IEvenementService {
    EvenementRepository evenementRepository;

    @Override
    public Evenement addEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement getEvenement(Long IdEvenement) {
        return evenementRepository.findById(IdEvenement).orElse(null);
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Void deleteBy(Long IdEvenement) {
        evenementRepository.deleteById(IdEvenement);
        return null;
    }

    @Override
    public Evenement updateEvenement(Evenement evenement) {
        Evenement ev = evenementRepository.findById(evenement.getIdEvent()).orElse(null);
        if (ev != null)
            evenementRepository.save(evenement);

        return ev;
    }
}