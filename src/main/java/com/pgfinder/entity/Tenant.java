package com.pgfinder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenantid")
    private int tenantid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phonenumber")
    private String phonenumber;

    public Tenant(int tenantid, String name, String email, String password, String phonenumber) {
        this.tenantid = tenantid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public Tenant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getTenantid() {
        return tenantid;
    }

    public void setTenantid(int tenantid) {
        this.tenantid = tenantid;
    }

}
