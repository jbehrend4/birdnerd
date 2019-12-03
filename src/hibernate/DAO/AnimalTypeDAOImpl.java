package hibernate.DAO;

import hibernate.entity.AnimalType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalTypeDAOImpl implements AnimalTypeDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<AnimalType> getAnimalTypes() {
        Session session = factory.getCurrentSession();

        List<AnimalType> list = session.createQuery("from AnimalType", AnimalType.class).getResultList();

        return list;
    }

    @Override
    public void saveAnimalType(AnimalType animalType) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(animalType);
    }

    @Override
    public AnimalType animalType(int id) {
        Session session = factory.getCurrentSession();

        return session.get(AnimalType.class, id);
    }

    @Override
    public void deleteAnimalType(int id) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("delete from AnimalType where AnimalTypeID = :typeToRemove");

        query.setParameter("typeToRemove", id);

        query.executeUpdate();
    }

    @Override
    public List<AnimalType> getAnimalTypesByName(String search) {
        Session session = factory.getCurrentSession();

        Query<AnimalType> query = session.createQuery("from AnimalType where lower(ANIMALTYPENAME) like :searchTerm");

        search = "%" + search.toLowerCase() + "%";

        query.setParameter("searchTerm", search);

        return query.getResultList();
    }
}
