package cw.sas.dao.impl;

import cw.sas.dao.NotificationDao;
import cw.sas.model.Notification;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 1/11/2017.
 */
@Repository
public class NotificationDaoImpl extends DaoImpl<Notification, Long> implements NotificationDao {
    @Override
    public List<Notification> getPropertyNotifications(String username) {
        Notification notification = null;
        try {
            Query query
                    = entityManager.createQuery("SELECT c FROM " + entityClass.getName()
                    + " c WHERE c.propertyOwner = :username");

            query.setParameter("username", username);
            List<Notification> properties = query.getResultList();
            return properties;
        } catch (NoResultException e) {
            return null;
        }
    }
}

