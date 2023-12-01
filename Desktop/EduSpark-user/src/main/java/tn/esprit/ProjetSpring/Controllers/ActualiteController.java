package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IActualiteService;
import tn.esprit.ProjetSpring.entities.Actualite;

import java.util.List;
@RestController
@AllArgsConstructor
public class ActualiteController {
    IActualiteService actualiteService;


    @PostMapping("/addactualite")
    Actualite  addActualite (@RequestBody Actualite actualite){
        return actualiteService.addActualite(actualite);
    }

    @GetMapping("/actualite/{id}")
    Actualite retrieveActualite(@PathVariable Long id){
        return actualiteService.getActualite((id));
    }

    @GetMapping("/actualites")
    List<Actualite> retrieveActualites(Actualite actualite){
        return actualiteService.getAllActualites();
    }


    @PutMapping("/actualite")
    Actualite updateActualite (@RequestBody Actualite actualite)
    {
        return actualiteService.updateActualite(actualite);
    }

    @DeleteMapping("/actualite/{id}")
    void deleteActualite(@PathVariable Long id){

        actualiteService.deleteActualite(id);
    }

}
