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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Creates Item Superclass Object
 * @author josh
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item  implements Serializable {

    // Attributes
        public static final String ITEM = "Item.findAllItems";
    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long item_id;
    @Column(nullable = true)
    public Long b_id;
    @Column(nullable = true)
    public String manufacturer;
    @Column(nullable = true)
    public String item_name;
    @Size(max = 2000)
    @Column(length = 2000)
    public String description;
    @Column(nullable = true)
    public double item_price;

    /**
     * Empty Constructor
     */
    public Item() {
    }
    
    /**
     * Constructor with Data
     * @param b_id
     * @param item_name
     * @param manufacturer
     * @param description
     * @param item_price
     */
    public Item(long b_id ,String item_name, String manufacturer, String description, double item_price) 
    {
        this.b_id = b_id;
        this.item_name = item_name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.item_price = item_price;
        
    }
    
    /**
     * Get and Set Methods
     * @return 
     */    
    public Long getId() {
        return item_id;
    }

    public void setId(Long i) {
        this.item_id = i;
    }
    
    public Long getB_id() {
        return b_id;
    }

    public void setB_id(Long i) {
        this.b_id = i;
    }
    
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String i) {
        this.item_name = i;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String m) {
        this.manufacturer = m;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double i) {
        this.item_price = i;
    }
  
    /**
     * Search Methods
     */  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (item_id != null ? item_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        Item other = (Item) o;
        if ((this.item_id == null && other.item_id != null) || (this.item_id != null && !this.item_id.equals(other.item_id))) {
            return false;
        }
        return true;
    }
    
    /**
     * ToString Override Method
     * */
    @Override
    public String toString() {
        return String.format (
       "%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
            "Barcode: ",Long.toString(b_id),
            "Item Name: ",this.item_name,
            "Manufacturer: ",this.manufacturer, 
            "Item Price: ",Double.toString(item_price),
            "Category: ",this.description
        );
    } 
}