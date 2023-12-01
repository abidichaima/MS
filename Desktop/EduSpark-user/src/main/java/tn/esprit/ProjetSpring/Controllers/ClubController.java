package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IClubService;
import tn.esprit.ProjetSpring.entities.Club;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClubController {

    IClubService iClubService;

    @GetMapping("/club")
    List<Club> retriveAllClub(Club club){
        return iClubService.getAllClubs();
    }

    @GetMapping("/club/{id}")
    Club retriveClub(@PathVariable Long id){
        return iClubService.getClub(id);
    }

    @PostMapping("/club")
    Club addClub(@RequestBody Club club){
        return iClubService.addClub(club);
    }

    @PutMapping("/club")
    Club updateClub (@RequestBody Club club){
        return iClubService.updateClub(club);
    }

    @DeleteMapping("/club/{id}")
    void deleteClub(@PathVariable Long id){
        iClubService.deleteById(id);
    }
}

