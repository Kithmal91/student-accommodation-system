package cw.sas.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 1/10/2017.
 */
@XmlRootElement
public class PropertyRequest {

    private String propertyName;
    private String location;
    private String propertyType;
    private String maximumTenants;
    private String amountRent;
    private String username;
    private String status;
    private Long id;
    private String fee;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getMaximumTenants() {
        return maximumTenants;
    }

    public void setMaximumTenants(String maximumTenants) {
        this.maximumTenants = maximumTenants;
    }

    public String getAmountRent() {
        return amountRent;
    }

    public void setAmountRent(String amountRent) {
        this.amountRent = amountRent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
