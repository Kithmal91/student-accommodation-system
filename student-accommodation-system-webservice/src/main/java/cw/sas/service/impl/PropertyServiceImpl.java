package cw.sas.service.impl;

import cw.sas.dao.FeeDao;
import cw.sas.dao.PropertyDao;
import cw.sas.dao.UserDao;
import cw.sas.model.*;
import cw.sas.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public String saveProperty(PropertyRequest request) throws Exception {

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
            
            return "success";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String editProperty(PropertyRequest request) throws Exception {

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
            propertyDao.create(property);
            return "success";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Property> readProperties() throws Exception {
        List<Property> propertyList = propertyDao.findAll();
        return propertyList;
    }
}
