package cw.sas.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by User on 1/10/2017.
 */
@Entity
@Table(name = "sas_pm_fee")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fee_id", nullable = false)
    private Long id;

    /* specify the property owner */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_name")
    private SystemUser user;

    /* specify the property owner */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property propertyId;

    /* specify the fee */
    @Column(name = "fee")
    private Double fee;

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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Calendar getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Calendar addedDate) {
        this.addedDate = addedDate;
    }

    public Property getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Property propertyId) {
        this.propertyId = propertyId;
    }
}
