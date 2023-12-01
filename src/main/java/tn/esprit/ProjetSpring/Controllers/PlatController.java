package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IPlatService;
import tn.esprit.ProjetSpring.entities.Niveau;
import tn.esprit.ProjetSpring.entities.Plat;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlatController {

    IPlatService platService;


    @PostMapping("/Platadd")
    Plat addPlat(@RequestBody Plat plat) {
        return platService.addPlat(plat);
    }

    @PutMapping("/Platupdate")
    Plat updatePlat(@RequestBody Plat plat) {
        return platService.updatePlat(plat);
    }

    @GetMapping("/Plat/{id}")
    Plat getPlatByid(@PathVariable long id) {
        return platService.getPlatByid(id);
    }


    @GetMapping("/Plats")
    List<Plat> getAlPlats() {
        return platService.getAllPlats();
    }
    @DeleteMapping("/Plat/{id}")
    void deletePlat(@PathVariable long id) {
        platService.deletePlat(id);
    }
}
