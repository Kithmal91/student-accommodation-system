package cw.sas.application;

import com.google.gson.Gson;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
            final Property property = propertyService.saveProperty(request);
            return Response.ok(property).build();
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
            final Property property = propertyService.editProperty(request);
            return Response.ok(property).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @PermitAll
    @GET
    @Path("/read-properties")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readProperties(@QueryParam("username") String username) throws Exception {

        try {
            final List<Property> properties = propertyService.readProperties(username);
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

    @GET
    @Path("/generate-available-property-report")
    public Response generateAvailablePropertyReports() throws Exception {

        Document document = new Document();
        try {
            Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
            FileOutputStream file = new FileOutputStream(new File("E:\\report\\Available_Properties.pdf"));
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("Available Properties", blueFont));

            com.itextpdf.text.List orderedList = new com.itextpdf.text.List(com.itextpdf.text.List.ORDERED);
            final List<Property> properties = propertyService.getAllAvailableProperties();

            for (Property property : properties) {
                orderedList.add(new ListItem("Property Name - " + property.getPropertyName() + "\n" + "Location - " +
                        property.getLocation() + "\n" + "Maximum Tenants = " + property.getMaximumTenants() + "\n" + "Rental - " + property.getAmountRent()
                        + "\n" + "Property Owner's Name - " + property.getUser().getName() + "\n" + "Property Owner's Mobile Number - " + property.getUser().getMobileNumber()));
            }
            document.add(orderedList);
            document.close();
            writer.close();
            return Response.ok(200).build();
        } catch (DocumentException e) {
            throw e;
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
}

