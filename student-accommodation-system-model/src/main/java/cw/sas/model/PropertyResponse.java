package cw.sas.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 1/10/2017.
 */
@XmlRootElement
public class PropertyResponse {

    private String propertyName;
    private String location;
    private String propertyType;
    private String maximumTenants;
    private String amountRent;
    private String username;
    private String status;

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
}
