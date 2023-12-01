package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Club;

import java.util.List;

public interface IClubService {
    Club addClub (Club club);

    Club getClub(Long IdClub);

    List<Club> getAllClubs();

    Void deleteById (Long IdClub);

    Club updateClub (Club club);
}
