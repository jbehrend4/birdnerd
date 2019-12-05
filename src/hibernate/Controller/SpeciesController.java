package hibernate.Controller;

import hibernate.entity.Species;
import hibernate.service.AnimalTypeService;
import hibernate.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/species")
public class SpeciesController {
    @Autowired
    private SpeciesService speciesService;

    @Autowired
    private AnimalTypeService animalTypeService;

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String search, Model model) {
            List<Species> list = speciesService.getSpeciesSearch(search);

            model.addAttribute("species", list);

            return "list-species";

    }

    @GetMapping("/delete")
    public String deleteSpecies(@RequestParam("speciesID") int id) {
        speciesService.deleteSpecies(id);

        return "redirect:/species/list";
    }

    @RequestMapping("/list")
    public String listSpecies(Model model) {
        List<Species> speciesList = speciesService.getSpecies();

        model.addAttribute("species", speciesList);

        return "list-species";
    }

    @GetMapping("/addSpecies")
    public String addSpeciesForm(Model model) {
        Species species = new Species();
        model.addAttribute("species", species);
        model.addAttribute("animalType", animalTypeService.getAnimalTypes());
        return "add-animal";
    }

    @RequestMapping("/updateSpecies")
    public String editSpeciesForm(@RequestParam("speciesID") int id,
                                      Model theModel) {
        Species species = speciesService.getSpecies(id);

        theModel.addAttribute("species", species);

        theModel.addAttribute("animalType", animalTypeService.getAnimalTypes());

        return "add-animal";
    }

    @PostMapping("/save")
    public String saveSpecies(Species species,
                            Model theModel ) {

        speciesService.saveSpecies(species);

        return "redirect:/species/list";
    }

}
