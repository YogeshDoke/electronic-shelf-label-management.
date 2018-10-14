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

import Beans.utility.Producer;
import Entities.CustOrder;

import Entities.Customer;

import Entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Sub class of Producer for Entity
 * @author josh
 */
@Stateless
public class CustOrderProducer extends Producer<CustOrder> {

    @PersistenceContext(unitName = "assignmnet2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
 
    // Constructor
    public CustOrderProducer() {
        super(CustOrder.class);
    }

    // Find Item from String
    public Item findItemName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = builder.createQuery(Item.class);
        Root<Item> i = cq.from(Item.class);
        cq.select(i).where(builder.equal(i.get("item_name"), name));
        TypedQuery<Item> query = em.createQuery(cq);
        return query.getSingleResult();
    }
    
    // Find Item from Id
    public Item findItem(long id) {
        return em.getReference(Item.class, id);
    }

    // Find All Items
    public List<Item> findAllItems() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = builder.createQuery(Item.class);
        Root<Item> i = cq.from(Item.class);
        cq.select(i);
        TypedQuery<Item> query = em.createQuery(cq);
        return query.getResultList();
    }

    // Find All CustOrders
    public List<CustOrder> findAllCustOrders() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CustOrder> cq = builder.createQuery(CustOrder.class);
        Root<CustOrder> i = cq.from(CustOrder.class);
        cq.select(i);
        TypedQuery<CustOrder> query = em.createQuery(cq);
        return query.getResultList();
    }

    // Find CustOrders from Id
    public List<CustOrder> findCustOrders(long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CustOrder> cq = builder.createQuery(CustOrder.class);
        Root<CustOrder> i = cq.from(CustOrder.class);
        cq.select(i).where(builder.equal(i.get("custord_id"), id));
        TypedQuery<CustOrder> query = em.createQuery(cq);
        return query.getResultList();
    }

    // Find CustOrder from Customer
    public List<CustOrder> findCustOrder(Customer customer) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<CustOrder> cq = builder.createQuery(CustOrder.class);
        Root<CustOrder> i = cq.from(CustOrder.class);
        cq.select(i).where(builder.equal(i.get("customer"), customer));
        TypedQuery<CustOrder> query = em.createQuery(cq);
        return query.getResultList();
    }

    // Find Customer from Id
    public Customer findCustomer(long id) {
        return em.getReference(Customer.class, id);
    }
    
    //Find Customer by Name
    public Customer findName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = builder.createQuery(Customer.class);
        Root<Customer> i = cq.from(Customer.class);
        cq.select(i).where(builder.equal(i.get("name"), name));
        Query query = em.createQuery(cq);
        return (Customer) query.getSingleResult();
    }
}
