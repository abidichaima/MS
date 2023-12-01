package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.INiveauService;
import tn.esprit.ProjetSpring.entities.Matieres;
import tn.esprit.ProjetSpring.entities.Niveau;

import java.util.List;

@RestController
@AllArgsConstructor
public class NiveauController {
    INiveauService niveauService;

    @PostMapping("/Niveauadd")
    Niveau addNiveau(@RequestBody Niveau niveau) {
        return niveauService.addNiveau(niveau);
    }

    @PutMapping("/Niveauupdate")
    Niveau updateNiveau(@RequestBody Niveau niveau) {
        return niveauService.updateNiveau(niveau);
    }

    @GetMapping("/Niveau/{id}")
    Niveau getNiveauById(@PathVariable long id) {
        return niveauService.getNiveauById(id);
    }


    @GetMapping("/Niveau")
    List<Niveau> getAllNiveaux() {
        return niveauService.getAllNiveau();
    }
    @DeleteMapping("/Niveau/{id}")
    void deleteNiveau(@PathVariable long id) {
        niveauService.deleteNiveau(id);
    }
}
