/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "PET")

@SequenceGenerator(name = "petid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petid_seq")
    private int petid;
    private String p_name;
    @Temporal(TemporalType.DATE)
    private Calendar p_dob;
    private double p_price;

    @ManyToOne()
    @JoinColumn(name="EMPID")
    private EmpCarer empC;
//    private Employee emp;

    @ManyToOne()
    @JoinColumn(name="BREEDID")
    private Breed breed;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PETFOOD",
            joinColumns = @JoinColumn(name = "PETID"),
            inverseJoinColumns = @JoinColumn(name = "FOODID"))
    private List<Food> flist = new ArrayList<>();
    
    
    
    public Pet() {
    }

    public Pet(String p_name, Calendar p_dob, double p_price) {
        this.p_name = p_name;
        this.p_dob = p_dob;
        this.p_price = p_price;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Calendar getP_dob() {
        return p_dob;
    }

    public void setP_dob(Calendar p_dob) {
        this.p_dob = p_dob;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }
    
//    public void setEmp(Employee e){
//        this.emp = e;
//    }
    
    public void setEmpC(EmpCarer e){
        this.empC = e;
   }
    
    public void setBreed(Breed b) {
        this.breed = b;
    }

    public List<Food> getFlist() {
        return flist;
    }

    public void setFlist(List<Food> flist) {
        this.flist = flist;
    }
    
    

  
    

    @Override 
    public String toString() {
                String s = String.format(" Pet Id: %1$-10d"
                + "Name: %2$-10s "
                + "DOB: %3$tb %3$td %3$-10tY"
                + "Price: %4$-10.2f",
                petid, p_name, p_dob, p_price);
        
        return s;
    }
    
    public void printFood(){
        System.out.println("Food for: "+p_name);
        for (int i = 0; i < flist.size(); i++) {
            System.out.println(flist.get(i));
            
        }
    }
}
