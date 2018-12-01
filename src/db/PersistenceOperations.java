/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.List;
import javax.persistence.*;
import model.Food;
import model.Owner;
import model.Pet;

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

    public void showPets() {
        em.getTransaction().begin();

        TypedQuery<Pet> query
                = em.createQuery("SELECT p FROM Pet p ORDER BY p.petid",
                        Pet.class);
        List<Pet> results = query.getResultList();

        for (Pet o : results) {
            System.out.println(o);
        }
        em.getTransaction().commit();
    }

    public void showOwners() {
        em.getTransaction().begin();

        TypedQuery<Owner> query
                = em.createQuery("SELECT o FROM Owner o ORDER BY o.ownid",
                        Owner.class);
        List<Owner> results = query.getResultList();

        for (Owner o : results) {
            System.out.println(o);
        }
        em.getTransaction().commit();
    }

    public void showBreeds() {
    }

    public void showFood() {
    }

    public void addOwner(String name, String address, String pNum) {
        em.getTransaction().begin();
        Owner o = new Owner(name, address, pNum);
        em.persist(o);
        em.getTransaction().commit();
    }
    
//    public void deleteFood(int foodid){
//        Food f = em.find(Food.class, f);
//        em.getTransaction().begin();
//        
//        em.remove(f);
//        f.remove();
//        em.getTransaction().commit();
//    }
}
