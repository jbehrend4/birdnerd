package hibernate.DAO;

import hibernate.entity.Species;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
