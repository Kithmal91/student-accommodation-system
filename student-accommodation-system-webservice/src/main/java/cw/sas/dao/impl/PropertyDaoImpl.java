package cw.sas.dao.impl;

import cw.sas.dao.PropertyDao;
import cw.sas.model.Property;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
@Repository
public class PropertyDaoImpl extends DaoImpl<Property, Long> implements PropertyDao {

    @Override
    public List<Property> readPropertiesByUsername(String username) {
        Property property = null;
        try {
            Query query
                    = entityManager.createQuery("SELECT c FROM " + entityClass.getName()
                    + " c WHERE c.user.username = :username");

            query.setParameter("username", username);
            List<Property> properties = query.getResultList();
            return properties;
        } catch (NoResultException e) {
            return null;
        }
    }
}
