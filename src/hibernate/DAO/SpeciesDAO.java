package hibernate.DAO;

import hibernate.entity.Species;

import java.util.List;

public interface SpeciesDAO {
    List<Species> getSpecies();

    Species getSpecies(int id);
}
