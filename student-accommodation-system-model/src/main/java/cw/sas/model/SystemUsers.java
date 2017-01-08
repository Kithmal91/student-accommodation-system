package cw.sas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by User on 1/7/2017.
 */
@Entity
@Table(name = "user")
public class SystemUsers {

    @Id
    @Column(name = "user_name")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
