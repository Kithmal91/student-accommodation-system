package cw.sas.dao;

import cw.sas.model.Property;

import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
public interface PropertyDao extends IDao<Property, Long> {

    List<Property> readPropertiesByUsername(final String username);

    List<Property> getAvailableProperties();
}
