package cw.sas.service;

import cw.sas.model.Notification;
import cw.sas.model.NotificationRequest;
import cw.sas.model.Property;
import cw.sas.model.PropertyRequest;

import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
public interface PropertyService {

    /**
     * Save Property
     *
     * @param request
     * @return
     * @throws Exception
     */
    String saveProperty(PropertyRequest request) throws Exception;

    /**
     * Edit Property
     *
     * @param request
     * @return
     * @throws Exception
     */
    String editProperty(PropertyRequest request) throws Exception;

    /**
     * Read all properties
     *
     * @return
     * @throws Exception
     */
    List<Property> readProperties() throws Exception;

    /**
     * read properties by username
     *
     * @param username
     * @param userType
     * @return
     */
    List<Property> readPropertiesByUsername(String username, String userType) throws Exception;

    /**
     * send property notifications
     *
     * @param request
     * @return
     * @throws Exception
     */
    String sendPropertyNotification(NotificationRequest request) throws Exception;


    /**
     * get property notifications for a user
     *
     * @param ownerName
     * @return
     * @throws Exception
     */
    List<Notification> getPropertyNotifications(String ownerName) throws Exception;


}
