package cw.sas.application;

import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.SystemUsers;
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
    public Response createPostRequest(RegisterRequest request) {
        System.out.println("Request : " + request.getUserType() + request.getEmail()
                + request.getMobileNumber() + request.getPassword() + request.getPassword());
        RegisterResponse user = service.saveUser(request);
        return Response.ok(user).build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPostRequest(@QueryParam("username") String username) {

        System.out.println("Username" + username);
        final SystemUsers user = service.getUser(username);
        return Response.ok(user).build();
    }
}
