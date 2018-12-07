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
    
    @OneToMany(mappedBy = "breed",cascade = CascadeType.ALL)
    private List<Pet> plist = new ArrayList<>();

    public Breed() {
    }
    
   

    public Breed(String b_name, String b_size) {
        this.b_name = b_name;
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
        String s = String.format(" Breed Id: %1$-10d"
                + "Name: %2$-15s"
                + "Size: %3$-10s",
                breedid, b_name, b_size);
        
        for (int i = 0; i < plist.size(); i++) {
            s += "\n        " + plist.get(i);
        }
        
        s+="\n";
        return s;
    }
    
    
    
    
    
    
}
