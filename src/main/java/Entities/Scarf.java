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
import javax.validation.constraints.NotNull;

/**
 * Creates Scarf Subclass Object
 *
 */
@Entity
public class Scarf extends Item implements Serializable 
{

    // Attributes
    public static final String SCARFS = "Scarf.findAllScarfs";
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = true)
    public long t_id;
    @Column(nullable = true)
    public double discount;
    @Column(nullable = true)
    public double final_price;
    
    
   /* @Column(nullable = true)
    private String style;
    @Column(nullable = true)
    private String colour;
    @Column(nullable = true)
    private String material;
    @Column(nullable = true)
    private int s_length;*/

    /**
     * Empty Constructor
     */
    public Scarf() {
    }

    /**
     * Constructor with Data
     * @param b_id
     * @param item_name
     * @param manufacturer
     * @param description
     * @param item_price
     * @param t_id
     * @param discount
     * @param final_price

     */
    public Scarf(long b_id, String item_name, String manufacturer, String description, double item_price, double discount, double final_price) {
        super(b_id, item_name, manufacturer, description, item_price);
        this.t_id = t_id;
        this.discount = discount;
        this.final_price = final_price;
    }

    /**
     * Get and Set Methods
     *
     * @return
     */
    
     public Long getT_id() {
        return t_id;
    }

    public void setT_id(Long i) {
        this.t_id = i;
    }
    
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double i) {
        this.discount = i;
    }
    
    public double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(double i) {
        this.final_price = i;
    }

    /**
     * ToString Override Method
     */
    @Override
    public String toString() {
        return String.format(
                "%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
                "Item ID: ", Long.toString(this.item_id),
                "Barcode: ", Long.toString(this.b_id),
                "Item Name: ", this.item_name,
                "Manufacturer: ", this.manufacturer,
                "Description: ", this.description,
                "Item Price: ", Double.toString(item_price),
                "Tag ID: ", Long.toString(this.t_id),
                "Discount: ", Double.toString(discount),
                "Final Price: ", Double.toString(final_price)
                
        );
    }

}