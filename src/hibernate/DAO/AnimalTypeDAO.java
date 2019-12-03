package hibernate.DAO;

import hibernate.entity.AnimalType;

import java.util.List;

public interface AnimalTypeDAO {
    List<AnimalType> getAnimalTypes();

    void saveAnimalType(AnimalType animalType);

    AnimalType animalType(int id);

    void deleteAnimalType(int id);

    List<AnimalType> getAnimalTypesByName(String search);
}
