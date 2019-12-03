package hibernate.Controller;

import hibernate.entity.Species;
import hibernate.service.AnimalTypeService;
import hibernate.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private AnimalTypeService animalTypeService;

}
