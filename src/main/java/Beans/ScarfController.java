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
import Entities.Scarf;
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
@Named("scarfController")
@SessionScoped
public class ScarfController implements Serializable {

    String search = ""; // Used as search string
    private List<Scarf> s = new ArrayList(); // Search results
    private Scarf scarf; 
    @EJB
    private ScarfProducer producer;

    // Constructor
    public ScarfController() {
    }

    // Initialize Scarf
    public void initializeScarf() {
        scarf = new Scarf();
    }

    // Get Producer
    private ScarfProducer getProducer() {
        return producer;
    }

    // Set search string
    public void setSearch(String s) {
        search = s;
    }

    // Get Search String
    public String getSearch() {
        return search;
    }

    // Get list of Scarfs S
    public List<Scarf> getS() {
        return s;
    }

    // Set list of Scarfs S
    public void setS(List<Scarf> s) {
        this.s = s;
    }

    // Clear list of Scarfs S
    public void clearS() {
        this.s.clear();
    }

    // Get Scarf
    public Scarf getSelected() {
        if (scarf == null) {
            scarf = new Scarf();
        }
        return scarf;
    }

    // Find All
    public List<Scarf> findAll() {
        return producer.findAll();
    }

    // Find Scarf by ID
    public void findScarf() {
        scarf = producer.find(scarf.getId());
    }

    // Find Scarf by item_name
    public void findName() {
        this.s = producer.findName(search);
    }

    // Persist Scarf
    public String persistScarf() {
        try {
            getProducer().create(scarf);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemCreated"));
            initializeScarf();
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Update Scarf
    public String updateScarf() {
        try {
            getProducer().edit(scarf);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemUpdated"));
            return "List";
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    // Delete Scarf 
    public String deleteScarf() {
        scarf = getSelected();
        try {
            getProducer().remove(scarf);
            Messanger.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ItemDeleted"));
        } catch (Exception e) {
            Messanger.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "List";
    }

}
