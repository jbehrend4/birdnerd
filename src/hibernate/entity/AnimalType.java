package hibernate.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "ANIMALTYPE")
public class AnimalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMALTYPEID")
    int AnimalTypeID;
    @NotNull
    @Column(name = "ANIMALTYPENAME")
    String AnimalTypeName;

    public AnimalType() {
    }

    public AnimalType(String animalTypeName) {
        AnimalTypeName = animalTypeName;
    }

    public int getAnimalTypeID() {
        return AnimalTypeID;
    }

    public void setAnimalTypeID(int animalTypeID) {
        AnimalTypeID = animalTypeID;
    }

    public String getAnimalTypeName() {
        return AnimalTypeName;
    }

    public void setAnimalTypeName(String animalTypeName) {
        AnimalTypeName = animalTypeName;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "AnimalTypeID=" + AnimalTypeID +
                ", AnimalTypeName='" + AnimalTypeName + '\'' +
                '}';
    }
}
