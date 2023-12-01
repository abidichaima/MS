package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.PlatRepository;
import tn.esprit.ProjetSpring.entities.Bloc;
import tn.esprit.ProjetSpring.entities.Plat;

import java.util.List;
@Service
@AllArgsConstructor
public class PlatService implements IPlatService{
    PlatRepository platRepository;
    @Override
    public Plat addPlat(Plat plat) {
        return platRepository.save(plat);
    }

    @Override
    public Plat getPlatByid(Long id) {
        return platRepository.findById(id).orElse(null);
    }

    @Override
    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    @Override
    public void deletePlat(long idPlat) {
        platRepository.deleteById(idPlat);
    }

    @Override
    public Plat updatePlat(Plat plat) {
        Plat pl=platRepository.findById(plat.getIdPlat()).orElse(null);
        if (pl!=null)
            platRepository.save(plat);
        return  pl;
    }
}
