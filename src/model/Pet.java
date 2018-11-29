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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")

@SequenceGenerator(name = "petid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petid_seq")
    private int petid;
    private String petname;
    @Temporal(TemporalType.DATE)
    private String petDOB;
    private String petDatePurchased;
    private int breedid,ownid;
    
    public Pet() {
    }

    public Pet(String petname, String petDOB, String petDatePurchased) {
        this.petname = petname;
        this.petDOB = petDOB;
        this.petDatePurchased = petDatePurchased;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetDOB() {
        return petDOB;
    }

    public void setPetDOB(String petDOB) {
        this.petDOB = petDOB;
    }

    public String getPetDatePurchased() {
        return petDatePurchased;
    }

    public void setPetDatePurchased(String petDatePurchased) {
        this.petDatePurchased = petDatePurchased;
    }

    public int getBreedid() {
        return breedid;
    }

    public void setBreedid(int breedid) {
        this.breedid = breedid;
    }

    public int getOwnid() {
        return ownid;
    }

    public void setOwnid(int ownid) {
        this.ownid = ownid;
    }
    
    
    
}
