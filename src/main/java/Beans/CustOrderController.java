/*
 * Copyright (custorder) 2015, josh
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
import Entities.CustOrder;
import Entities.Customer;
import Entities.Item;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Managed Bean for CustOrder Entity
 *
 * @author josh
 */
@Named("custorderController")
@SessionScoped
public class CustOrderController implements Serializable {

    long id; // Used as search long
    String search; // Used as search string
    List<CustOrder> custorderarray = new ArrayList(); // Search results
    CustOrder custorder;
    Item item;

    @EJB
    private CustOrderProducer producer;

    // Constructor
    public CustOrderController() {
    }

    // Initialize CustOrder
    public void initializeCustomer(long id) {
        this.custorder.setCustomer(producer.findCustomer(id));
    }

    // Initialize CustOrder
    public void initializeCustOrder(long id) {
        custorder = new CustOrder(producer.findCustomer(id));
    }

    // Initialize CustOrder
    public void initializeCustOrder() {
        custorder = new CustOrder();
    }

    // Get Producer
    private CustOrderProducer getProducer() {
        return producer;
    }

    // Get Hat
    public CustOrder getSelected() {
        if (custorder == null) {
            custorder = new CustOrder();
        }
        return custorder;
    }

    // Gets local Id
    public long getId() {
        return id;
    }

    // Gets local Item
    public Item getItem() {
        return item;
    }

    // Gets local CustOrder Array used for listing all CustOrders
    public List<CustOrder> getCustOrderArray() {
        return custorderarray;
    }

    // Gets local search String
    public String getSearch() {
        return search;
    }

    // Sets local search String 
    public void setSearch(String search) {
        this.search = search;
    }

    // Gets local CustOrder 
    public CustOrder getCustorder() {
        return custorder;
    }

    // Sets local CustOrder 
    public void setCustorder(CustOrder custorder) {
        this.custorder = custorder;
    }

    // Sets local Id
    public void setId(long id) {
        this.id = id;
    }

    // Sets local Item
    public void setItem(long id) {
        this.item = producer.findItem(id);
    }

    // Sets local CustOrder Array used for listing all CustOrders
    public void setCustorderarray(List<CustOrder> custorderarray) {
        this.custorderarray = custorderarray;
    }

    // Clear local array of all CustOrders
    public void clearS() {
        this.custorderarray.clear();
    }

    // Add local Item to CustOrder    
    public void addOrder(long id) {
        setItem(id);
        this.custorder.addItem(item);
    }

    // Add local Item to CustOrder    
    public void removeOrder(long id) {
        setItem(id);
        this.custorder.removeItem(item);
    }

    // Finds selected Customer and add it to CustOrder, returns created CustOrder.Customer
    public Customer findCustomer() {
        this.custorder.setCustomer(producer.findCustomer(this.custorder.getCustomer().getCustomer_id()));
        return this.custorder.getCustomer();
    }

    // Finds all Items in inventory
    public List<Item> findAllItems() {
        return producer.findAllItems();
    }

    // Find All CustOrders
    public List<CustOrder> findAll() {
        return producer.findAllCustOrders();
    }

    // Find CustOrder by ID and add to CustOrderArray
    public void findCustOrderSearch() {
        this.custorderarray = producer.findCustOrders(id);
    }

    // Find CustOrder by Customer and add it to CustOrderArray
    public void findCustOrderCustomerSearch() {
        this.custorderarray = producer.findCustOrder(producer.findName(search));
    }

    // Find CustOrder 
    public void findCustOrders() {
        this.custorder = producer.find(custorder.getCustord_id());
    }

    // Clear CustOrderArray Search Results
    public void clearCustOrderArray() {
        this.custorderarray.clear();
    }

    // Clear CustOrderArray Search Results
    public void clearCustOrder() {
        this.custorder = null;
    }

    // Persist CustOrder
    public String persistCustOrder() {
        try {
            getProducer().create(custorder);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCreated"));
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Update CustOrder
    public String updateCustOrder() {
        try {
            getProducer().edit(custorder);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemUpdated"));
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Delete CustOrder
    public String deleteCustOrder() {
        custorder = getSelected();
        try {
            getProducer().remove(custorder);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemDeleted"));
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "List";
    }

}
