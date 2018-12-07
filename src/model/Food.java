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
@Table(name = "FOOD")

@SequenceGenerator(name = "foodid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Food {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foodid_seq")
    private int foodid;
    private String f_name;
    private double f_price;
    private int f_servings;
    private String f_type;

    @ManyToMany(mappedBy = "flist", cascade = CascadeType.PERSIST)
    private List<Pet> plist = new ArrayList<>();

    
    public Food() {
    }

    public Food(String f_name, double f_price, int f_servings, String f_type) {
        this.f_name = f_name;
        this.f_price = f_price;
        this.f_servings = f_servings;
        this.f_type = f_type;
    }
    
    public void addPet(Pet p){
        plist.add(p);
        p.getFlist().add(this);
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public double getF_price() {
        return f_price;
    }

    public void setF_price(double f_price) {
        this.f_price = f_price;
    }

    public int getF_servings() {
        return f_servings;
    }

    public void setF_servings(int f_servings) {
        this.f_servings = f_servings;
    }

    public String getF_type() {
        return f_type;
    }

    public void setF_type(String f_type) {
        this.f_type = f_type;
    }

    public List<Pet> getPlist() {
        return plist;
    }

    public void setPlist(List<Pet> plist) {
        this.plist = plist;
    }

    @Override 
    public String toString() {
        String s = String.format(" Food Id: %1$-10s "
                + "Name: %2$-20s"
                + "Price: %3$-10.2f"
                + "Servings: %4$-10d"
                + "Type: %5$-10s",
                foodid, f_name, f_price, f_servings, f_type);
        
        return s;
    }
    public void printPets(){
        System.out.println("Pets that eat this food " + f_name);
        for (int i = 0; i < plist.size(); i++) {
            System.out.println(plist.get(i));
        }
    }
    
}
