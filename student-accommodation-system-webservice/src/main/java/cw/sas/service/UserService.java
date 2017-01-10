package cw.sas.service;

import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.SystemUser;

import javax.persistence.NoResultException;

/**
 * Created by Kithmal on 11/7/2015.
 */
public interface UserService {

    /**
     * Save System User
     *
     * @param request
     * @return
     */
    RegisterResponse saveUser(final RegisterRequest request) throws Exception, NoResultException;

    /**
     * Get user by username
     *
     * @param username
     * @return
     */
    SystemUser getUser(final String username) throws Exception;

    /**
     * check user auth
     */
    Boolean checkUserAuth(final String username, final String password) throws Exception;
}
