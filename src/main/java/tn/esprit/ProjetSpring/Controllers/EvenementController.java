package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IEvenementService;
import tn.esprit.ProjetSpring.entities.Evenement;

import java.util.List;
@RestController
@AllArgsConstructor
public class EvenementController {
    IEvenementService iEvenementService;
    @GetMapping("/evenements")
    List<Evenement> retriveAllEvenement(Evenement evenement){
        return iEvenementService.getAllEvenements();
    }

    @GetMapping("/evenement/{id}")
    Evenement retriveEvenement(@PathVariable Long id){
        return iEvenementService.getEvenement(id);
    }

    @PostMapping("/evenement")
    Evenement addEvenement(@RequestBody Evenement evenement){
        return iEvenementService.addEvenement(evenement);
    }

    @PutMapping("/evenement")
    Evenement updateEvenement (@RequestBody Evenement evenement){
        return iEvenementService.updateEvenement(evenement);
    }

    @DeleteMapping("/evenement/{id}")
    void deleteEvenement(@PathVariable Long id){
        iEvenementService.deleteBy(id);
    }
}

