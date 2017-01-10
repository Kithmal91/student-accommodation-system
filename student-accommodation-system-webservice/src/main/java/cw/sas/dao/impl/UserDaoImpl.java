package cw.sas.dao.impl;

import cw.sas.dao.UserDao;
import cw.sas.model.SystemUser;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 11/7/2015.
 */
@Repository
public class UserDaoImpl extends DaoImpl<SystemUser, String> implements UserDao {
}
