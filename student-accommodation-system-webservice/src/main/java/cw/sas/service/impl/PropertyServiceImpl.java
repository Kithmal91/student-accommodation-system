package cw.sas.service.impl;

import cw.sas.dao.FeeDao;
import cw.sas.dao.NotificationDao;
import cw.sas.dao.PropertyDao;
import cw.sas.dao.UserDao;
import cw.sas.model.*;
import cw.sas.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private FeeDao feeDao;

    @Autowired
    private NotificationDao notificationDao;

    @Override
    @Transactional
    public Property saveProperty(PropertyRequest request) throws Exception {

        Property property = new Property();
        property.setStatus(Status.ACTIVE);
        property.setAmountRent(new BigDecimal(request.getAmountRent()));
        property.setLocation(request.getLocation());
        property.setMaximumTenants(request.getMaximumTenants());
        property.setPropertyName(request.getPropertyName());
        property.setPropertyType(request.getPropertyType());
        final SystemUser user = userDao.read(request.getUsername());
        property.setUser(user);

        try {
            final Property prop = propertyDao.create(property);

            //insert Fee
            Fee fee = new Fee();
            fee.setUser(user);
            fee.setFee(Double.parseDouble(request.getFee()));
            fee.setPropertyId(prop);
            feeDao.create(fee);

            return prop;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public Property editProperty(PropertyRequest request) throws Exception {

        final Property property = propertyDao.read(request.getId());

        if (request.getStatus().equalsIgnoreCase("ACTIVE")) {
            property.setStatus(Status.ACTIVE);
        } else {
            property.setStatus(Status.INACTIVE);
        }
        property.setAmountRent(new BigDecimal(request.getAmountRent()));
        property.setLocation(request.getLocation());
        property.setMaximumTenants(request.getMaximumTenants());
        property.setPropertyName(request.getPropertyName());
        property.setPropertyType(request.getPropertyType());
        final SystemUser user = userDao.read(request.getUsername());
        property.setUser(user);

        try {
            final Property updatedProperty = propertyDao.update(property);
            return updatedProperty;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Property> readProperties(final String username) throws Exception {
        //get all properties
        List<Property> requestedProperties = new ArrayList<>();

        for (Property property : propertyDao.findAll()) {
            final String propertyName = property.getPropertyName();
            Boolean status = notificationDao.isNotificationsRequestByUsernameAndPropertyName(username, propertyName);
            if (status) {
                property.setStatus(Status.REQUESTED);
                requestedProperties.add(property);
            } else {
                property.setStatus(Status.NOT_REQUESTED);
                requestedProperties.add(property);
            }
        }
        return requestedProperties;
    }

    @Override
    public List<Property> readPropertiesByUsername(String username, String userType) throws Exception {
        try {
            List<Property> properties = propertyDao.readPropertiesByUsername(username);
            return properties;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public String sendPropertyNotification(NotificationRequest request) throws Exception {
        Notification notification = new Notification();

        //get system user
        final SystemUser user = userDao.read(request.getUsername());
        notification.setUser(user);

        //get property
        final Property property = propertyDao.read(Long.parseLong(request.getPropertyId()));
        notification.setPropertyId(property);
        notification.setPropertyOwner(property.getUser().getUsername());
        try {
            notificationDao.create(notification);
            return "success";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Notification> getPropertyNotifications(String ownerName) throws Exception {
        try {
            final List<Notification> propertyNotifications = notificationDao.getPropertyNotifications(ownerName);
            return propertyNotifications;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Double getFeesByUsername(String username) throws Exception {
        final List<Fee> fees = feeDao.getFees(username);
        int size = 0;

        if (fees.size() > 0) {
            size = fees.size();
        } else {
            size = 0;
        }

        if (size != 0) {
            Double fee = new Double(size * 100);
            return fee;
        } else {
            return new Double(0);
        }
    }
}
