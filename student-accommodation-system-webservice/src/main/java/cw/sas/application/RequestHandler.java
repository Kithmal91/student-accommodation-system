package cw.sas.application;

import cw.sas.model.RegisterRequest;
import cw.sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by User on 11/7/2015.
 */
@Component
@Path("/user-service")
public class RequestHandler {

    @Autowired
    private UserService service;

    @PermitAll
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public String createPostRequest(RegisterRequest request) {
        System.out.println("Request : " + request);
        service.saveUser(request);
        return "success";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPostRequest(@QueryParam("firstName") String firstName,
                                      @QueryParam("lastName") String lastName) {

        String fullName = new StringBuilder().append(firstName).append(" ").append(lastName).toString();
        return Response.ok(fullName).build();
    }
}
