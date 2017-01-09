package cw.sas.service;

import cw.sas.model.RegisterRequest;
import cw.sas.model.RegisterResponse;
import cw.sas.model.SystemUsers;

/**
 * Created by Kithmal on 11/7/2015.
 */
public interface UserService {

    RegisterResponse saveUser(final RegisterRequest request);

    /**
     * Get user by username
     *
     * @param username
     * @return
     */
    SystemUsers getUser(final String username);
}
