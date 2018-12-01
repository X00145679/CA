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
    @Temporal(TemporalType.DATE)
    private Calendar p_datePurchased;

    
    
    public Pet() {
    }

    public Pet(int petid, String p_name, Calendar p_dob, Calendar p_datePurchased) {
        this.petid = petid;
        this.p_name = p_name;
        this.p_dob = p_dob;
        this.p_datePurchased = p_datePurchased;

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

    public Calendar getP_datePurchased() {
        return p_datePurchased;
    }

    public void setP_datePurchased(Calendar p_datePurchased) {
        this.p_datePurchased = p_datePurchased;
    }
    
    

    @Override 
    public String toString() {
                String s = String.format(" Pet Id: %1$-10d"
                + "Name: %2$-10s "
                + "DOB: %3$tb %3$td %3$-10tY"
                + "Date Purchased: %4$tb %4$td %4$-10tY",
                petid, p_name, p_dob, p_datePurchased);
        
        return s;
    }
}
