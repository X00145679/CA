package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author David
 */

@Entity
@Table(name = "BREED")
@Inheritance(strategy = InheritanceType.JOINED)


@SequenceGenerator(name = "breedid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breedid_seq")
    private int breedid;
    private String b_name,b_size;
    @Temporal(TemporalType.DATE)
    private String b_exp_years;

    public Breed(String b_name, String b_size, String b_exp_years) {
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

    public String getB_exp_years() {
        return b_exp_years;
    }

    public void setB_exp_years(String b_exp_years) {
        this.b_exp_years = b_exp_years;
    }

    @Override
    public String toString() {
        return "Breed: " + "\n Breed Id: " + breedid + "\n name:" + b_name + "\n size:" + b_size + "\n exp years:" + b_exp_years;
    }
    
}
