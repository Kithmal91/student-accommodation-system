package cw.sas.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by User on 1/7/2017.
 */
@Entity
@Table(name = "sas_um_user")
public class SystemUser {

    @Id
    @Column(name = "user_name")
    private String username;

    /* specify the customer name */
    @Column(name = "name")
    private String name;

    /* specify the passwords */
    @Column(name = "password")
    private String password;

    /* specify the email */
    @Column(name = "email")
    private String email;

    /* specify the address */
    @Column(name = "address")
    private String address;

    /* specify the mobile number */
    @Column(name = "mobile_number")
    private String mobileNumber;

    /* specify the user type */
    @Column(name = "user_type")
    private String userType;

    /* specify the user status */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    /* specify the added date */
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar addedDate;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Calendar getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Calendar addedDate) {
        this.addedDate = addedDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
