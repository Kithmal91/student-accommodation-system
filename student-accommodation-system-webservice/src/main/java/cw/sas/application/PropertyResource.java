package cw.sas.application;

import cw.sas.model.Property;
import cw.sas.model.PropertyRequest;
import cw.sas.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
@Component
@Path("/property-service")
public class PropertyResource {

    @Autowired
    private PropertyService propertyService;

    @PermitAll
    @POST
    @Path("/save-property")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProperty(PropertyRequest request) throws Exception {

        try {
            propertyService.saveProperty(request);
            return Response.ok("success").build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @POST
    @Path("/edit-property")
    @Produces(MediaType.APPLICATION_JSON)
    public Response editProperty(PropertyRequest request) throws Exception {

        try {
            propertyService.editProperty(request);
            return Response.ok("success").build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @GET
    @Path("/read-properties")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readProperties() throws Exception {

        try {
            final List<Property> properties = propertyService.readProperties();
            return Response.ok(properties).build();
        } catch (Exception e) {
            throw e;
        }
    }

}


