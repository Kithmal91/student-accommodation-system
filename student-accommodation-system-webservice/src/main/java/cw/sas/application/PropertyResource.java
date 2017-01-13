package cw.sas.application;

import com.google.gson.Gson;
import cw.sas.model.Notification;
import cw.sas.model.NotificationRequest;
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

    @Autowired(required = false)
    private PropertyService propertyService;

    @PermitAll
    @POST
    @Path("/save-property")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProperty(PropertyRequest request) throws Exception {

        try {
            final String result = propertyService.saveProperty(request);
            return Response.ok(result).build();
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
            Gson gson = new Gson();

            return Response.ok(gson.toJson(properties)).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @GET
    @Path("/read-properties-by-username")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPropertiesByUsername(@QueryParam("username") String username, @QueryParam("userType") String userType) throws Exception {

        try {
            final List<Property> properties = propertyService.readPropertiesByUsername(username, userType);
            Gson gson = new Gson();
            return Response.ok(gson.toJson(properties)).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @POST
    @Path("/send-notification")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendPropertyNotification(NotificationRequest request) throws Exception {

        try {
            String result = propertyService.sendPropertyNotification(request);
            return Response.ok(result).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @GET
    @Path("/get-notification")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPropertyNotification(@QueryParam("username") String username) throws Exception {
        try {
            final List<Notification> propertyNotifications = propertyService.getPropertyNotifications(username);
            Gson gson = new Gson();
            return Response.ok(gson.toJson(propertyNotifications)).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @GET
    @Path("/get-fee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeesByUsername(@QueryParam("username") String username) throws Exception {
        try {
            final Double fee = propertyService.getFeesByUsername(username);
            return Response.ok(fee).build();
        } catch (Exception e) {
            throw e;
        }
    }


}

