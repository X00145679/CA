/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.persistence.*;
import model.Owner;

/**
 *
 * @author x00148542
 */
public class PersistenceOperations {

    EntityManagerFactory emf;
    EntityManager em;

    public PersistenceOperations() {
        emf = Persistence.createEntityManagerFactory("PetShopCAPU");
        em = emf.createEntityManager();
    }

    public void addOwner(String name, String address, String pNum) {
        em.getTransaction().begin();
        Owner o = new Owner(name, address, pNum);
        em.persist(o);
        em.getTransaction().commit();
    }
}
