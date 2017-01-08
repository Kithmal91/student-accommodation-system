package cw.sas.dao.impl;

import cw.sas.dao.UserDao;
import cw.sas.model.SystemUsers;
import org.springframework.stereotype.Repository;

/**
 * Created by Kithmal on 11/7/2015.
 */
@Repository
public class UserDaoImpl extends DaoImpl<SystemUsers, String> implements UserDao {

}
