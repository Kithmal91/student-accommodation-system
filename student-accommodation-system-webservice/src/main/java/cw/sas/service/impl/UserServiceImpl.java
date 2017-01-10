package cw.sas.service.impl;

import cw.sas.dao.UserDao;
import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.Status;
import cw.sas.model.SystemUser;
import cw.sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

/**
 * Created by Kithmal on 11/7/2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public RegisterResponse saveUser(final RegisterRequest request) throws Exception, NoResultException {

        //check whether the user already exsists
        if (userDAO.read(request.getUsername()) != null) {
            throw new NoResultException();
        }

        SystemUser user = new SystemUser();
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setName(request.getName());

        //encode password
        user.setPassword(encoder.encode(request.getPassword()));
        user.setUserType(request.getUserType());
        user.setUsername(request.getUsername());
        user.setStatus(Status.ACTIVE);
        user.setAddress(request.getAddress());

        // RegisterResponse response = (RegisterResponse) LazyBeanUtils.copyBean(RegisterResponse.class, request);

        RegisterResponse response = new RegisterResponse();
        response.setEmail(request.getEmail());
        response.setMobileNumber(request.getMobileNumber());
        response.setName(request.getName());
        response.setPassword(request.getPassword());
        response.setUserType(request.getUserType());
        response.setUsername(request.getUsername());
        response.setStatus(user.getStatus().getType());

        try {
            userDAO.create(user);
        } catch (Exception e) {
            throw e;
        }
        return response;
    }

    @Override
    public SystemUser getUser(String username) throws Exception {
        try {
            final SystemUser user = userDAO.read(username);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean checkUserAuth(String username, String password) throws Exception {
        try {
            final SystemUser user = userDAO.read(username);
            final boolean isPasswordCorrect = encoder.matches(password, user.getPassword());
            return isPasswordCorrect;
        } catch (Exception e) {
            throw e;
        }
    }
}
