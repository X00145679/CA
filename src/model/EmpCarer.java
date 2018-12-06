/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@DiscriminatorValue("CARER")
@PrimaryKeyJoinColumn(referencedColumnName = "empid")

@SuppressWarnings("SerializableClass")

public class EmpCarer extends Employee {

    private double salary;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
    private List<Pet> plist = new ArrayList<>();

    public EmpCarer() {
    }

    public EmpCarer(String e_name, String e_pNum, double salary) {
        super(e_name, e_pNum);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String s = super.toString() + " Carer Employee Salary: " + salary;
        for (int i = 0; i < plist.size(); i++) {
            s += "\n" + plist.get(i) + "\n";
        }
        return s;
    }

    public void addPet(Pet p) {
        plist.add(p);
        p.setEmpC(this);
    }

}
