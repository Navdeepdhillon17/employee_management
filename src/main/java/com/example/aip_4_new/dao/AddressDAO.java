package com.example.aip_4_new.dao;

import com.example.aip_4_new.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AddressDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void addAddress(Address address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
        em.close();
    }
}
