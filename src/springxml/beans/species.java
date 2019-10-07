package springxml.beans;

import springxml.services.ordering;

import javax.persistence.criteria.Order;
import java.io.Console;
import java.util.ConcurrentModificationException;

public class species {

    private ordering o;
    private int speciesID;
    private String speciesName;
    private String animalType;

    public species() {
    }

    public species(ordering o) {
        this.o = o;
    }

    public int getSpeciesID() {
        return speciesID;
    }

    public void setSpeciesID(int speciesID) {
        this.speciesID = speciesID;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setOrder(ordering o) {
        this.o = o;
    }

    public void checkOrder(ordering o) {
        System.out.println(o.getItemsInCart());
    }

}
