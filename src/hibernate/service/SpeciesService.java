package hibernate.service;

import hibernate.entity.Species;

import java.util.List;

public interface SpeciesService {
    List<Species> getSpecies();

    Species getSpecies(int id);
}
