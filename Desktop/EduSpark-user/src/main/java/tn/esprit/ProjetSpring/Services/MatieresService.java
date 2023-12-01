package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.MatieresRepository;
import tn.esprit.ProjetSpring.entities.Matieres;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MatieresService implements IMatieresService{
    MatieresRepository matieresRepository;
    @Override
    public Matieres addMatiere(Matieres matieres) {
        return matieresRepository.save(matieres);
    }

    @Override
    public Matieres getMatiereById(Integer id) {
        return matieresRepository.findById(id).orElse(null);
    }

    @Override
    public List<Matieres> getAllMatieres() {
        return matieresRepository.findAll();
    }

    @Override
    public Matieres updateMatiere(Matieres matieres) {
        return matieresRepository.save(matieres);
    }

    @Override
    public void deleteMatiere(Integer id) {
        matieresRepository.deleteById(id);

    }
}
