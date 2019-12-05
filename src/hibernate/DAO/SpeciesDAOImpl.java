package hibernate.DAO;

import hibernate.entity.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpeciesDAOImpl implements SpeciesDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Species> getSpecies() {
        Session session = factory.getCurrentSession();

        List<Species> list = session.createQuery("from Species", Species.class).getResultList();

        return list;
    }

    @Override
    public Species getSpecies(int id) {
        Session session = factory.getCurrentSession();

        return session.get(Species.class, id);
    }

    @Override
    public List<Species> getSpeciesSearch(String search) {
        Session session = factory.getCurrentSession();

        Query<Species> query = session.createQuery("from Species where lower(SpeciesName) like :searchTerm");

        search = "%" + search.toLowerCase() + "%";

        query.setParameter("searchTerm", search);

        return query.getResultList();
    }

    @Override
    public void deleteSpecies(int id) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("delete from Species where SpeciesID = :typeToRemove");

        query.setParameter("typeToRemove", id);

        query.executeUpdate();
    }

    @Override
    public void saveSpecies(Species species) {
        Session session = factory.getCurrentSession();

        session.saveOrUpdate(species);
    }
}
