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
package Beans;

import Beans.utility.Messanger;
import Entities.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 * Managed Bean for Customer Entity
 * @author josh
 */
@Named("customerController")
@SessionScoped
public class CustomerController implements Serializable {

    String search = ""; // Used as search string
    private List<Customer> s = new ArrayList(); // Search results
    private Customer customer;
    @EJB
    private CustomerProducer producer;

    // Constructor
    public CustomerController() {
    }

    // Initialize Customer
    public void initializeCustomer() {
        this.customer = new Customer();
    }

    // Get Producer
    private CustomerProducer getProducer() {
        return producer;
    }

    // Get Customer
    public Customer getSelected() {
        if (customer == null) {
            customer = new Customer();
        }
        return customer;
    }

    // Find Customer by name
    public void findName() {
        customer = producer.findName(search);
    }

    // Find Customers by name
    public void findNames() {
        s = producer.findNames(search);
    }

    // Clear list of Customers s
    public void clearS() {
        this.s.clear();
    }

    // Get Search string
    public String getSearch() {
        return search;
    }

    // Set Search string
    public void setSearch(String search) {
        this.search = search;
    }

    // Get list of Customers s
    public List<Customer> getS() {
        return s;
    }

    // Set list of Customers s
    public void setS(List<Customer> s) {
        this.s = s;
    }

    // Find All Customers
    public List<Customer> findAll() {
        return producer.findAll();
    }

    // Find Customer
    public void findCustomer() {
        this.customer = producer.find(customer.getCustomer_id());
    }

    // Persist Customer
    public String persistCustomer() {
        try {
            getProducer().create(customer);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCreated"));
            initializeCustomer();
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Update Customer
    public String updateCustomer() {
        try {
            getProducer().edit(customer);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemUpdated"));
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Delete Customer 
    public String deleteCustomer() {
        customer = getSelected();
        try {
            getProducer().remove(customer);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemDeleted"));
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "List";
    }

}
