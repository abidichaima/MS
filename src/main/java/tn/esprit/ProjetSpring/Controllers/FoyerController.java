package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IFoyerService;
import tn.esprit.ProjetSpring.entities.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerController {
    IFoyerService foyerService;

    @PostMapping("/addfoyer")
    Foyer addFoyer (@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("/foyer/{id}")
    Foyer retrievefoyer(@PathVariable Long id){

        return foyerService.getFoyer(id);
    }

    @GetMapping("/foyers")
    List<Foyer> retrieveFoyer(Foyer foyer){

        return foyerService.getAllFoyers();
    }


    @PutMapping("/foyer")
    Foyer updateFoyer (@RequestBody Foyer foyer)
    {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/foyer/{id}")
    void deleteFoyer(@PathVariable Long id){

        foyerService.deleteFoyer(id);
    }
}
