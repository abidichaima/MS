package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Bloc;

import java.util.List;
public interface IBlocService {
    Bloc addBloc(Bloc bloc);

    Bloc getBloc(Long id);

    List<Bloc> getAllBlocs();

    void deleteBloc(long idBloc);

    Bloc updateBloc(Bloc bloc);

}
