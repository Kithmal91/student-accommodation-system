package cw.sas.service.impl;

import cw.sas.dao.UserDao;
import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.SystemUsers;
import cw.sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Kithmal on 11/7/2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    @Transactional
    public RegisterResponse saveUser(final RegisterRequest request) {
        SystemUsers user = new SystemUsers();
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setUserType(request.getUserType());
        user.setUsername(request.getUsername());

        RegisterResponse response = new RegisterResponse();
        response.setEmail(request.getEmail());
        response.setMobileNumber(request.getMobileNumber());
        response.setName(request.getName());
        response.setPassword(request.getPassword());
        response.setUserType(request.getUserType());
        response.setUsername(request.getUsername());

        try {
            userDAO.create(user);
        } catch (Exception e) {
            response.setResponseCode("01");
            response.setResponseMsg(e.getMessage());
            return response;
        }
        response.setResponseCode("00");
        return response;
    }

    @Override
    public SystemUsers getUser(String username) {
        final SystemUsers user = userDAO.read(username);
        return user;
    }
}
