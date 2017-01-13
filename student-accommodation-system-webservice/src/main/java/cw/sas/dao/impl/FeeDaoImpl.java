package cw.sas.dao.impl;


import cw.sas.dao.FeeDao;
import cw.sas.model.Fee;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
@Repository
public class FeeDaoImpl extends DaoImpl<Fee, Long> implements FeeDao {

    @Override
    public List<Fee> getFees(String username) {
        try {
            Query query
                    = entityManager.createQuery("SELECT c FROM " + entityClass.getName()
                    + " c WHERE c.user.username = :username");

            query.setParameter("username", username);
            List<Fee> properties = query.getResultList();
            return properties;
        } catch (NoResultException e) {
            return null;
        }
    }
}
