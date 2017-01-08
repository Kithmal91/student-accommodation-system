package cw.sas.service.impl;

import cw.sas.dao.UserDao;
import cw.sas.model.RegisterRequest;
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
    public void saveUser(final RegisterRequest request) {
        SystemUsers user = new SystemUsers();
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setUserType(request.getUserType());
        userDAO.create(user);
    }
}
