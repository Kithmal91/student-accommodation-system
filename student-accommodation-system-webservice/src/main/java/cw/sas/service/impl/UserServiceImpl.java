package cw.sas.service.impl;

import cw.sas.dao.UserDao;
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
    public void saveUser(final String username) {
        SystemUsers user = new SystemUsers();
        user.setUsername(username);
        userDAO.create(user);
    }
}
