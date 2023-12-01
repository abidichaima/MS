package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.ClubRepository;
import tn.esprit.ProjetSpring.entities.Club;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubService implements IClubService{
    ClubRepository clubRepository;


    @Override
    public Club addClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Club getClub(Long IdClub) {
        return clubRepository.findById(IdClub).orElse(null);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Void deleteById(Long IdClub) {
        clubRepository.deleteById(IdClub);
        return null;
    }

    @Override
    public Club updateClub(Club club) {
        Club cl=clubRepository.findById(club.getIdClub()).orElse(null);
        if (cl!=null)
            clubRepository.save(club);
        return cl;
    }
}