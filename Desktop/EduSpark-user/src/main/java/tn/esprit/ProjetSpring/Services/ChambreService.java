package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.ChambreRepository;
import tn.esprit.ProjetSpring.entities.Chambre;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements IChambreService {


     ChambreRepository chambreRepository;


    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambre(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public void deleteChambre(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        Chambre ch=chambreRepository.findById(chambre.getIdChambre()).orElse(null);
        if (ch!=null)
            chambreRepository.save(chambre);
        return  ch;
    }
}
