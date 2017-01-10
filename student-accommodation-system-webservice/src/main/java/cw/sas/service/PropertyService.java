package cw.sas.service;

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


}
