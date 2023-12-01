package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.NiveauRepository;
import tn.esprit.ProjetSpring.entities.Niveau;

import java.util.List;

@Service
@AllArgsConstructor

public class NiveauService implements INiveauService{
    NiveauRepository niveauRepository;
    @Override
    public Niveau addNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau getNiveauById(Long id) {
        return niveauRepository.findById(id).orElse(null);
    }

    @Override
    public List<Niveau> getAllNiveau() {
        return niveauRepository.findAll();
    }

    @Override
    public Niveau updateNiveau(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public void deleteNiveau(Long id) {
        niveauRepository.deleteById(id);
    }
}
