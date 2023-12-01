package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.ActualiteRepository;
import tn.esprit.ProjetSpring.entities.Actualite;
import tn.esprit.ProjetSpring.entities.Bloc;

import java.util.List;

@Service
@AllArgsConstructor

public class ActualiteService implements IActualiteService {
    ActualiteRepository actualiteRepository;
    @Override
    public Actualite addActualite(Actualite actualite) {
        return actualiteRepository.save(actualite);
    }

    @Override
    public Actualite getActualite(Long id) {
        return actualiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Actualite> getAllActualites() {
        return actualiteRepository.findAll();
    }

    @Override
    public void deleteActualite(long idActualite) {
        actualiteRepository.deleteById(idActualite);

    }

    @Override
    public Actualite updateActualite(Actualite actualite) {
        Actualite ac=actualiteRepository.findById(actualite.getIdActualite()).orElse(null);
        if (ac!=null)
            actualiteRepository.save(actualite);
        return  ac;
    }
}
