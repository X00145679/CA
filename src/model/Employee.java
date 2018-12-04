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

@SequenceGenerator(name = "empid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empid_seq")
    private String e_name;
    private String e_pNum;
    private double e_payRate;
    private int empid, e_hours;
    
    @OneToMany(mappedBy = "emp",cascade = CascadeType.ALL)
    private List<Pet> plist = new ArrayList<>();

    public Employee() {
    }

    public Employee(String e_name, String e_pNum, double e_payRate, int e_hours) {
        this.e_name = e_name;
        this.e_pNum = e_pNum;
        this.e_payRate = e_payRate;
        this.e_hours = e_hours;
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

    public double getE_payRate() {
        return e_payRate;
    }

    public void setE_payRate(double e_payRate) {
        this.e_payRate = e_payRate;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getE_hours() {
        return e_hours;
    }

    public void setE_hours(int e_hours) {
        this.e_hours = e_hours;
    }
    
    public void addPet(Pet p){
        plist.add(p);
        p.setEmp(this);
    }


   
    @Override
    public String toString() {
        String s = String.format(" Employee Id: %1$-10d"
                + "Name: %2$-10s"
                + "Phone Num: %3$-15s"
                + "Pay Rate: %4$-10.2f"
                + "Hours: %5$-10d",
                empid, e_name, e_pNum, e_payRate, e_hours);
        
        return s;
    }

}
