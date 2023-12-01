package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.UniversiteRepository;
import tn.esprit.ProjetSpring.entities.Universite;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{

     UniversiteRepository universiteRepository;



    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversite(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public void deleteUniversite(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        Universite univ=universiteRepository.findById(universite.getIdUniversite()).orElse(null);
        if (univ!=null)
            universiteRepository.save(universite);
        return  univ;
    }
}
