package com.mobiledev.rpm.androidtemplate.main.data.model;

import com.google.gson.annotations.SerializedName;
import com.mobiledev.rpm.androidtemplate.main.data.local.db.AndroidTemplateDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by rmanacmol on 10/8/2016.
 */
@Table(database = AndroidTemplateDB.class)
public class Users extends BaseModel {

    @PrimaryKey
    @Column
    @SerializedName("id")
    private int id;
    @Column
    @SerializedName("name")
    private String name;
    @Column
    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private Address address;
    @Column
    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String website;

    @SerializedName("company")
    private Company company;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
