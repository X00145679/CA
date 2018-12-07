package db;

import java.util.Calendar;
import java.util.List;
import javax.persistence.*;
import model.Breed;
import model.FullTime;
import model.PartTime;
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

        for (Employee e : results) {
            System.out.println(e);
        }
        em.getTransaction().commit();
    }
    
    public void showPartTime() {
        em.getTransaction().begin();

        TypedQuery<PartTime> query
                = em.createQuery("SELECT pt FROM PartTime pt ORDER BY pt.empid",
                        PartTime.class);
        List<PartTime> results = query.getResultList();

        for (PartTime pt : results) {
            System.out.println(pt);
        }
        em.getTransaction().commit();
    }
    
    
    
    public void showFullTime(){
        em.getTransaction().begin();

        TypedQuery<FullTime> query
                = em.createQuery("SELECT ft FROM FullTime ft ORDER BY ft.empid",
                        FullTime.class);
        List<FullTime> results = query.getResultList();

        for (FullTime ft : results) {
            System.out.println(ft);
        }
        em.getTransaction().commit();
    }
    
    
    
    
    
    

    //Add Methods
    public void addPartTime(String name, String pNum, double payRate, int hours) {
        em.getTransaction().begin();
        PartTime pt = new PartTime(name, pNum, payRate, hours);
        em.persist(pt);
        em.getTransaction().commit();
    }
    

    public void addFullTime( String name, String pNum, double salary) {
        em.getTransaction().begin();
        FullTime e = new FullTime(name, pNum, salary);
        em.persist(e);
        em.getTransaction().commit();
    }
    
    public void addPet(String p_name, Calendar p_dob, double p_price, int bid, int eid) {
        em.getTransaction().begin();
        Pet p = new Pet(p_name,p_dob,p_price);
        
        Employee e = em.find(Employee.class, eid);
        if(e != null){
            e.addPet(p);
        }
        
        Breed b = em.find(Breed.class, bid);
        if(b != null){
            b.addPet(p);
        }
        
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

    

    public void updatePartTime(int eid, double payRate, int hours) {
        PartTime pt = em.find(PartTime.class, eid);
        em.getTransaction().begin();
        pt.setPayRate(payRate);
        pt.setHours(hours);
        em.persist(pt);
        em.getTransaction().commit();
    }
    
    public void updateFullTime(int eid, double salary) {
        FullTime ft = em.find(FullTime.class, eid);
        em.getTransaction().begin();
        ft.setSalary(salary);
        em.persist(ft);
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
    
    public void veiwPetFood(int pid) {
        em.getTransaction().begin();
        Pet p = em.find(Pet.class, pid);
        p.printFood();
        em.getTransaction().commit();
    }
    
    public void veiwPetEmployee(int eid) {
        em.getTransaction().begin();
        Employee e = em.find(Employee.class, eid);
        e.printPets();
        em.getTransaction().commit();
    }

    //Close
    public void close(){
        em.close();
        emf.close();
    }
}
