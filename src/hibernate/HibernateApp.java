package hibernate;

import hibernate.entity.AnimalType;
import hibernate.entity.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(AnimalType.class)
                .addAnnotatedClass(Species.class)
                .buildSessionFactory();
    }

    public void close() {
        factory.close();
    }

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        try {
            app.CreateAnimalType();
            app.CreateSpecies();
            app.readAnimalType(1);
            app.readSpecies(1);
            app.updateAnimalType(1);
            app.readSpecies(1);
            app.deleteSpecies(1);
            app.deleteAnimalType(1);
        }
        finally {
            app.close();
        }
    }

    private int CreateAnimalType() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        AnimalType animalType= new AnimalType("Bird");

        session.save(animalType);

        session.getTransaction().commit();

        return animalType.getAnimalTypeID();
    }

    private void readAnimalType(int animalTypeID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        AnimalType animalType = session.get(AnimalType.class, animalTypeID);

        System.out.println(animalType);

        session.getTransaction().commit();
    }

    private void updateAnimalType(int animalTypeID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        AnimalType animalType = session.get(AnimalType.class, animalTypeID);
        if(animalType != null) {
            animalType.setAnimalTypeName(animalType.getAnimalTypeName().toUpperCase());
        }
        System.out.println(animalType);

        session.getTransaction().commit();
    }

    private void deleteAnimalType(int animalTypeID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        AnimalType animalType = session.get(AnimalType.class, animalTypeID);
        if(animalType != null) {
            session.delete(animalType);
        }

        System.out.println("Animal Type Deleted");

        session.getTransaction().commit();
    }

    private int CreateSpecies() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Species species = new Species("Cardinal", 1);

        session.save(species);

        session.getTransaction().commit();

        return species.getSpeciesID();
    }

    private void readSpecies(int speciesID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Species species = session.get(Species.class, speciesID);

        System.out.println(species);

        session.getTransaction().commit();
    }

    private void updateSpecies(int speciesID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Species species = session.get(Species.class, speciesID);
        if(species != null) {
            species.setSpeciesName(species.getSpeciesName().toUpperCase());
        }
        System.out.println(species);

        session.getTransaction().commit();
    }

    private void deleteSpecies(int speciesID) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Species species = session.get(Species.class, speciesID);
        if(species != null) {
            session.delete(species);
        }

        System.out.println("Species Deleted");

        session.getTransaction().commit();
    }
}
