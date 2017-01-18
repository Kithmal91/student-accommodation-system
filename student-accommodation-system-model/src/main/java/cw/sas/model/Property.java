package cw.sas.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by User on 1/10/2017.
 */
@Entity
@Table(name = "sas_pm_property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id", nullable = false)
    private Long id;

    /* specify the property name */
    @Column(name = "property_name")
    private String propertyName;

    /* specify the property location */
    @Column(name = "location")
    private String location;

    /* specify the property type */
    @Column(name = "property_type")
    private String propertyType;

    /* specify the maximum tennants */
    @Column(name = "maximum_tenants")
    private String maximumTenants;

    /* specify the amount */
    @Column(name = "amount_rent")
    private BigDecimal amountRent;

    /* specify the property owner */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_name")
    private SystemUser user;

    /* specify the property status */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    /* specify the added date */
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar addedDate;

    @Transient
    private Boolean isPropertyRequested;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getAmountRent() {
        return amountRent;
    }

    public void setAmountRent(BigDecimal amountRent) {
        this.amountRent = amountRent;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
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

    public Boolean isPropertyRequested() {
        return isPropertyRequested;
    }

    public void setIsPropertyRequested(Boolean isPropertyRequested) {
        this.isPropertyRequested = isPropertyRequested;
    }
}
