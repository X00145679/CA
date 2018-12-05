package db;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import model.Breed;
import model.Employee;
import model.Food;
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

        for (Pet p : results) {
            System.out.println(p);
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

    public void showEmployees() {
        em.getTransaction().begin();

        TypedQuery<Employee> query
                = em.createQuery("SELECT e FROM Employee e ORDER BY e.empid",
                        Employee.class);
        List<Employee> results = query.getResultList();

        for (Employee o : results) {
            System.out.println(o);
        }
        em.getTransaction().commit();
    }

    //Add Methods
    public void addEmployee(String name, String pNum, double payRate, int hours) {
        em.getTransaction().begin();
        Employee e = new Employee(name, pNum, payRate, hours);
        e.setE_name(name);
        e.setE_hours(hours);
        e.setE_pNum(pNum);
        e.setE_payRate(payRate);
        em.persist(e);
        em.getTransaction().commit();
    }

    public void addPet(String p_name, Calendar p_dob, double p_price) {
        em.getTransaction().begin();
        Pet p = new Pet(p_name,p_dob,p_price);
        em.persist(p);
        em.getTransaction().commit();
    }

    public void addFood(String name, double price, int servings, String type) {
        em.getTransaction().begin();
        Food f = new Food(name,price, servings, type);
        em.persist(f);
        em.getTransaction().commit();
    }

    //Remove Methods
    public void removePet(int pid) {
        Pet p = em.find(Pet.class, pid);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public void removeEmployee(int empid) {
        Employee e = em.find(Employee.class, empid);
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    //Update Methods
    public void updatePet(int pid, double price) {
        Pet p = em.find(Pet.class, pid);
        em.getTransaction().begin();
        p.setP_price(price);
        em.persist(p);
        em.getTransaction().commit();
        System.out.println(" row updated");
    }

    public void updateEmployee(int eid, double payRate, int hours) {
        Employee e = em.find(Employee.class, eid);
        em.getTransaction().begin();
        e.setE_payRate(payRate);
        e.setE_hours(hours);
        em.persist(e);
        em.getTransaction().commit();
    }
    
    public void updateFood(int fid, int servings, double price){
        Food f = em.find(Food.class, fid);
        em.getTransaction().begin();
        f.setF_servings(servings);
        f.setF_price(price);
        em.persist(f);
        em.getTransaction().commit();
    }
    
    //Query
    public void addPetFood(int pid, int fid){
        em.getTransaction().begin();
        Pet p = em.find(Pet.class, pid);
        Food f = em.find(Food.class, fid);
        f.addPet(p);
        em.getTransaction().commit();
    }

    //Close
    public void close(){
        em.close();
        emf.close();
    }
}
