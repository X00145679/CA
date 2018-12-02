package db;

import java.util.List;
import javax.persistence.*;
import model.Breed;
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
       em.getTransaction().begin();

        TypedQuery<Breed> query
                = em.createQuery("SELECT b FROM Breed b ORDER BY b.breedid",
                        Breed.class);
        List<Breed> results = query.getResultList();

        for (Breed b : results) {
            System.out.println(b);
        }
        em.getTransaction().commit(); 
        
    }

    public void showFood() {
        em.getTransaction().begin();

        TypedQuery<Food> query
                = em.createQuery("SELECT f FROM Food f ORDER BY f.foodid",
                        Food.class);
        List<Food> results = query.getResultList();

        for (Food f : results) {
            System.out.println(f);
        }
        em.getTransaction().commit();
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
