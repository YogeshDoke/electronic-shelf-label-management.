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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Creates and holds customer order Links customer - order - item
 *
 * @author josh
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class CustOrder implements Serializable {

    // Attributes
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custord_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "customer_fk")
    protected Customer customer;
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "custord_id")
    private List<Item> item;

    /**
     * Empty Constructor
     */
    public CustOrder() {
        Date date = new Date();
        this.creationDate = date;
        this.item = new LinkedList();
    }

    public CustOrder(Customer c) {
        this.customer = c;
        Date date = new Date();
        this.creationDate = date;
        this.item = new LinkedList();
    }

    /**
     * Get and Set Methods
     */
    public Long getCustord_id() {
        return custord_id;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public void setCustord_id(Long c) {
        this.custord_id = c;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date d) {
        this.creationDate = d;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer c) {
        this.customer = c;
    }

    public Item getItem(int index) {
        return item.get(index);
    }

    public void addItem(Item t) {
        this.item.add(t);
    }

    public void removeItem(Item t) {
        this.item.remove(t);
    }


    /**
     * Search Methods
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (custord_id != null ? custord_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CustOrder)) {
            return false;
        }
        CustOrder other = (CustOrder) o;
        if ((this.custord_id == null && other.custord_id != null) || (this.custord_id != null && !this.custord_id.equals(other.custord_id))) {
            return false;
        }
        return true;
    }

    /**
     * ToString Override Method
     */
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String s = String.format(
                "%s%s\n%s%s\n%s",
                "Customer Order ID: ", Long.toString(this.custord_id),
                "Order Date: ", df.format(this.creationDate),
                this.customer);
        return s;
    }

}
