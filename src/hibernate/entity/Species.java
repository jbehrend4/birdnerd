package hibernate.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SPECIESID")
    private int SpeciesID;
    @NotNull
    @Column(name = "SPECIESNAME")
    private String SpeciesName;
    @Column(name = "ANIMALTYPEID")
    @JoinTable(name = "species_animaltype",
            joinColumns = @JoinColumn(name = "ANIMALTYPEID"),
            inverseJoinColumns = @JoinColumn(name = "ANIMALTYPEID"))
    private int AnimalTypeID;

    public Species() {
    }

    public Species(String speciesName, int animalTypeID) {
        SpeciesName = speciesName;
        AnimalTypeID = animalTypeID;
    }

    public int getSpeciesID() {
        return SpeciesID;
    }

    public void setSpeciesID(int speciesID) {
        SpeciesID = speciesID;
    }

    public String getSpeciesName() {
        return SpeciesName;
    }

    public void setSpeciesName(String speciesName) {
        SpeciesName = speciesName;
    }

    public int getAnimalTypeID() {
        return AnimalTypeID;
    }

    public void setAnimalTypeID(int animalTypeID) {
        AnimalTypeID = animalTypeID;
    }

    @Override
    public String toString() {
        return "Species{" +
                "SpeciesID=" + SpeciesID +
                ", SpeciesName='" + SpeciesName + '\'' +
                ", AnimalTypeID=" + AnimalTypeID +
                '}';
    }
}
