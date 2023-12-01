package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.FoyerRepository;
import tn.esprit.ProjetSpring.entities.Foyer;

import java.util.List;
 @Service
 @AllArgsConstructor
public class FoyerService implements IFoyerService{
     FoyerRepository foyerRepository;


     @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyer(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public void deleteFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

     @Override
     public Foyer updateFoyer(Foyer foyer) {
         Foyer f=foyerRepository.findById(foyer.getIdFoyer()).orElse(null);
         if (f!=null)
             foyerRepository.save(foyer);
         return  f;
     }
}
