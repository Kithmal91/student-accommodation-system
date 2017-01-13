package cw.sas.dao;

import cw.sas.model.Fee;

import java.util.List;

/**
 * Created by User on 1/10/2017.
 */
public interface FeeDao extends IDao<Fee, Long> {

    List<Fee> getFees(String username);
}
