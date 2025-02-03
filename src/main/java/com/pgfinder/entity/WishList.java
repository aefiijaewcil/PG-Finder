package com.pgfinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist")
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistid;

    // One tenant can have many wishlist entries
    @ManyToOne
    @JoinColumn(name = "tenantid", nullable = false)
    private Tenant tenant;

    // @ManyToOne
    // @JoinColumn(name = "propertyid", nullable = false)
    // private Property property;

    @Column(name = "propertyid")
    private int propertyid;

    public WishList() {
    }

    public WishList(int wishlistid, Tenant tenant, int propertyid) {
        this.wishlistid = wishlistid;
        this.tenant = tenant;
        this.propertyid = propertyid;
    }

    public int getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(int wishlistid) {
        this.wishlistid = wishlistid;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public int getPropertyid() {
        return propertyid;
    }

    public void setPropertyId(int propertyid) {
        this.propertyid = propertyid;
    }
}
