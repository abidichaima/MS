package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IMatieresService;
import tn.esprit.ProjetSpring.entities.Matieres;

import java.util.List;
@RestController
@AllArgsConstructor
public class MatieresController {
    IMatieresService matieresService;



    @PostMapping("/Matiereadd")
    Matieres addMatiere(@RequestBody Matieres matieres) {
            return matieresService.addMatiere(matieres);
    }

    @PutMapping("/Matiereupdate")
    Matieres updateMatiere(@RequestBody Matieres matieres) {
        return matieresService.updateMatiere(matieres);
    }

    @GetMapping("/Matiere/{id}")
    Matieres getMatiereById(@PathVariable int id) {
        return matieresService.getMatiereById(id);
    }


    @GetMapping("/Matieres")
    List<Matieres> getAllMatieres() {
        return matieresService.getAllMatieres();
    }
    @DeleteMapping("/Matieres/{id}")
    void deleteMatiere(@PathVariable int id) {
        matieresService.deleteMatiere(id);
    }
}
