package cw.sas.service;

import cw.sas.model.RegisterRequest;

/**
 * Created by Kithmal on 11/7/2015.
 */
public interface UserService {

    void saveUser(final RegisterRequest request);
}
