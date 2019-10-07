package springxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springxml.beans.species;

public class SpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");

        species s = context.getBean("mySpecies", species.class);


        System.out.println(s.getSpeciesID());
        System.out.println(s.getSpeciesName());
        System.out.println(s.getAnimalType());

        context.close();
    }
}
