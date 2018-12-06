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
@DiscriminatorValue("FT")
@PrimaryKeyJoinColumn(referencedColumnName = "empid")

@SuppressWarnings("SerializableClass")

public class FullTime extends Employee {

    private double salary;


    public FullTime() {
    }

    public FullTime(String e_name, String e_pNum, double salary) {
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

        return s;
    }


}
