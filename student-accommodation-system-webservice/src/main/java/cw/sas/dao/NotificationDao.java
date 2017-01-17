package cw.sas.dao;

import cw.sas.model.Notification;

import java.util.List;

/**
 * Created by User on 1/11/2017.
 */
public interface NotificationDao extends IDao<Notification, Long> {

    List<Notification> getPropertyNotifications(String username);

    Boolean isNotificationsRequestByUsernameAndPropertyName(String propertyName, String username);
}
