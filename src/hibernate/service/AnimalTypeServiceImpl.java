package hibernate.service;

import hibernate.DAO.AnimalTypeDAO;
import hibernate.entity.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

public class AnimalTypeServiceImpl implements AnimalTypeService {
    @Autowired
    private AnimalTypeDAO dao;

    @Override
    @Transactional
    public List<AnimalType> getAnimalTypes() {
        return dao.getAnimalTypes();
    }

    @Override
    @Transactional
    public void saveAnimalType(AnimalType animalType, MultipartFile file, String applicationPath) {
        dao.saveAnimalType(animalType);
    }

    @Override
    @Transactional
    public AnimalType animalType(int id) {
        return dao.animalType(id);
    }

    @Override
    @Transactional
    public void deleteAnimalType(int id) {
        dao.deleteAnimalType(id);
    }

    @Override
    @Transactional
    public List<AnimalType> getAnimalTypeByName(String search) {
        return dao.getAnimalTypesByName(search);
    }
}
