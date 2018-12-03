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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@SequenceGenerator(name = "foodid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Food {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "foodid_seq")
    private int foodid;
    private String name;
    private double price;
    private int servings;
    private String type;
    
    public Food() {
        
    }

    public Food(String name, double price, int servings, String type) {
        
        this.name = name;
        this.price = price;
        this.servings = servings;
        this.type = type;
    }
    

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    @Override 
    public String toString() {
        String s = String.format(" Food Id: %1$-10s "
                + "Name: %2$-10s"
                + "Price: %3$-10.2f"
                + "Servings: %4$-10d"
                + "Type: %5$-10s",
                foodid, name, price, servings, type);
        
        return s;
    }
    
    
    
}
