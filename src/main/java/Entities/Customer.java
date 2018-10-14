/*
 * Copyright (c) 2015, josh
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.validation.constraints.NotNull;

/**
 * Creates Customer Object
 *
 * @author josh
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SecondaryTables({
    @SecondaryTable(name = "city")})
public class Customer implements Serializable {

    /**
     * Attributes
     */
    public static final String CUSTOMER = "Customer.findAllCustomers";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    @NotNull
    @Column(nullable = false)
    private String name;
    private String email;
    private String phone;
    @NotNull
    @Column(nullable = false)
    private String street1;
    private String street2;
    @NotNull
    @Column(table = "city",nullable = false)
    private String city;
    @NotNull
    @Column(table = "city",nullable = false)
    private String state;
    @NotNull
    @Column(table = "city",nullable = false)
    private String postcode;
    @NotNull
    @Column(table = "city",nullable = false)
    private String country;

    /**
     * Empty Constructor
     */
    public Customer() {
    }

    /**
     *
     * @param name
     * @param email
     * @param phone
     * @param street1
     * @param street2
     * @param city
     * @param state
     * @param postcode
     * @param country
     */
    public Customer(String name, String email, String phone,
            String street1, String street2, String city, String state,
            String postcode, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    /**
     * Get and Set Methods
     *
     * @return
     */
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String f_name) {
        this.name = f_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String s) {
        this.street1 = s;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String s) {
        this.street2 = s;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String c) {
        this.city = c;
    }

    public String getState() {
        return state;
    }

    public void setState(String s) {
        this.state = s;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String p) {
        this.postcode = p;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String c) {
        this.country = c;
    }

    /**
     * Search Methods
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customer_id != null ? customer_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customer_id == null && other.customer_id != null) || (this.customer_id != null && !this.customer_id.equals(other.customer_id))) {
            return false;
        }
        return true;
    }

  
   /**
     * toString Override Method
     */
    @Override
    public String toString() {
        return String.format("%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
                "Customer Name: ", this.name,
                "Email Address: ", this.email,
                "Phone Number: ", this.phone,
                "Street 1: ", street1,
                "Street 2: ", street2,
                "City: ", city,
                "State: ", state,
                "Postcode: ", postcode,
                "Country: ", country);
    }
}
