package hibernate.service;

import hibernate.entity.AnimalType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AnimalTypeService {
    List<AnimalType> getAnimalTypes();

    void saveAnimalType(AnimalType animalType, MultipartFile file, String applicationPath);

    AnimalType animalType(int id);

    void deleteAnimalType(int id);

    List<AnimalType> getAnimalTypeByName(String search);
}
