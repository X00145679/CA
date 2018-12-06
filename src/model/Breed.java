package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    private int b_exp_years;
    
    @OneToMany(mappedBy = "breed",cascade = CascadeType.ALL)
    private List<Pet> plist = new ArrayList<>();

    public Breed() {
    }
    
   

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

    public List<Pet> getPlist() {
        return plist;
    }

    public void setPlist(List<Pet> plist) {
        this.plist = plist;
    }
    
    public void addPet(Pet p){
        plist.add(p);
        p.setBreed(this);
    }
    

    @Override
    public String toString() {
            return String.format(" Breed Id: %1$-10d"
                + "Name: %2$-15s"
                + "Size: %3$-10s"
                + "Life Expectancy: %1$-10d",
                breedid, b_name, b_size, b_exp_years);
    }
    
    
    
    
    
    
}
