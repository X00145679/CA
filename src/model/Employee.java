package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author David
 */


@Entity
@Table(name = "EMPLOYEE")
@Inheritance( strategy = InheritanceType.JOINED)
@DiscriminatorColumn( name = "type" )

@SequenceGenerator(name = "empid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empid_seq")
    private int empid;
    private String e_name;
    private String e_pNum;

    
    @OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)
    private List<Pet> plist = new ArrayList<>();

    public Employee() {
    }

    public Employee(String e_name, String e_pNum) {
        this.e_name = e_name;
        this.e_pNum = e_pNum;

    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_pNum() {
        return e_pNum;
    }

    public void setE_pNum(String e_pNum) {
        this.e_pNum = e_pNum;
    }


    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public List<Pet> getPlist() {
        return plist;
    }

    public void setPlist(List<Pet> plist) {
        this.plist = plist;
    }
    
    

    public void addPet(Pet p){
        plist.add(p);
        p.setEmp(this);
    }


   
    @Override
    public String toString() {
        String s = String.format(" Employee Id: %1$-10d"
                + "Name: %2$-10s"
                + "Phone Num: %3$-15s",
                empid, e_name, e_pNum);
        
        return s;
    }
    
    public void printPets() {
        System.out.println("Employee that is in charge of these pets " + e_name);
        for (int i = 0; i < plist.size(); i++) {
            System.out.println(plist.get(i));
            
        }
    }

}
