package hibernate.service;

import hibernate.DAO.SpeciesDAO;
import hibernate.entity.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {
    @Autowired
    private SpeciesDAO dao;

    @Override
    @Transactional
    public List<Species> getSpecies() {
        return dao.getSpecies();
    }

    @Override
    @Transactional
    public Species getSpecies(int id) {
        return dao.getSpecies(id);
    }

    @Override
    @Transactional
    public List<Species> getSpeciesSearch(String search) {
        return dao.getSpeciesSearch(search);
    }

    @Override
    @Transactional
    public void deleteSpecies(int id) {
        dao.deleteSpecies(id);
    }

    @Override
    @Transactional
    public void saveSpecies(Species species) {
        dao.saveSpecies(species);
    }
}
