/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PT")
@PrimaryKeyJoinColumn(referencedColumnName = "empid")

@SuppressWarnings("SerializableClass")

public class PartTime extends Employee {
    private int hours;
    private double payRate;

    public PartTime() {
    }

    public PartTime(String e_name, String e_pNum, double payRate, int hours) {
        super(e_name, e_pNum);
        this.hours = hours;
        this.payRate = payRate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Shop Employee Hours: " + hours + ", Pay Rate: " + payRate;
    }
    
    
}
