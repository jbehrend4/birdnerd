package hibernate.DAO;

import hibernate.entity.Species;

import java.util.List;

public interface SpeciesDAO {
    List<Species> getSpecies();

    Species getSpecies(int id);

    List<Species> getSpeciesSearch(String search);

    void deleteSpecies(int id);

    void saveSpecies(Species species);
}
