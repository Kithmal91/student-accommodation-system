package cw.sas.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 1/11/2017.
 */
@XmlRootElement
public class NotificationRequest {

    private String propertyId;
    private String username;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
