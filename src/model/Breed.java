package model;

import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author David
 */

@Entity
@Table(name = "BREED")

@SequenceGenerator(name = "breedid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breedid_seq")
    private int breedid;
    private String b_name,b_size;
    @Temporal(TemporalType.DATE)
    private int b_exp_years;
    
   

    public Breed(String b_name, String b_size, int b_exp_years) {
        this.b_name = b_name;
        this.b_exp_years = b_exp_years;
        this.b_size = b_size;
        
    }

    public int getBreedid() {
        return breedid;
    }

    public void setBreedid(int breedid) {
        this.breedid = breedid;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_size() {
        return b_size;
    }

    public void setB_size(String b_size) {
        this.b_size = b_size;
    }

    public int getB_exp_years() {
        return b_exp_years;
    }

    public void setB_exp_years(int b_exp_years) {
        this.b_exp_years = b_exp_years;
    }

    @Override
    public String toString() {
            return String.format("Breed: %n"
                + "Breed ID: %d%n "
                + "Name: %s%n"
                + "Size: %s%n"
                + "Life Expectancy: %d%n",
                breedid, b_name, b_size, b_exp_years);
    }
    
    
    
    
    
    
}
