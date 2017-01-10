package cw.sas.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by User on 1/11/2017.
 */
@Entity
@Table(name = "sas_pm_notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id", nullable = false)
    private Long id;

    /* specify the system owner */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name")
    private SystemUser user;

    /* specify the property owner */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property propertyId;

    @Column(name = "property_owner")
    private String propertyOwner;

    /* specify the added date */
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar addedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }

    public Calendar getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Calendar addedDate) {
        this.addedDate = addedDate;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }
}
