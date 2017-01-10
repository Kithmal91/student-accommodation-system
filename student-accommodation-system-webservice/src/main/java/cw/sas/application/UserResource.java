package cw.sas.application;

import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.SystemUser;
import cw.sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by User on 11/7/2015.
 */
@Component
@Path("/user-service")
public class UserResource {

    @Autowired
    private UserService service;

    @PermitAll
    @POST
    @Path("/save-user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPostRequest(RegisterRequest request) throws Exception {

        System.out.println("Request : " + request.getUserType() + request.getEmail()
                + request.getMobileNumber() + request.getPassword() + request.getPassword());
        try {
            RegisterResponse user = service.saveUser(request);
            return Response.ok(user).build();
        } catch (NoResultException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    @Path("/get-user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPostRequest(@QueryParam("username") String username) throws Exception {

        System.out.println("Username" + username);
        try {
            final SystemUser user = service.getUser(username);
            return Response.ok(user).build();
        } catch (Exception e) {
            throw e;
        }
    }

    @GET
    @Path("/user-auth")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkLoginCredentials(@QueryParam("username") String username, @QueryParam("password") String password) throws Exception {

        System.out.println("Username : " + username + " " + "Password : " + password);
        try {
            final Boolean isPasswordCorrect = service.checkUserAuth(username, password);
            if (isPasswordCorrect) {
                final SystemUser user = service.getUser(username);
                return Response.ok(user).build();
            } else {
                return Response.ok(null).build();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
