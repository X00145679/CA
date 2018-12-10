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

    private int pt_hours;
    private double pt_payRate;

    public int getHours() {
        return pt_hours;
    }

    public void setHours(int hours) {
        this.pt_hours = hours;
    }

    public double getPayRate() {
        return pt_payRate;
    }

    public void setPayRate(double payRate) {
        this.pt_payRate = payRate;
    }

    public PartTime() {
    }

    public PartTime(double payRate, int hours) {
        this.pt_hours = hours;
        this.pt_payRate = payRate;
    }

    public PartTime(String e_name, String e_pNum, double payRate, int hours) {
        super(e_name, e_pNum);
        this.pt_hours = hours;
        this.pt_payRate = payRate;
    }

    @Override
    public String toString() {
        return super.toString() + " PartTime Employee Hours: " + pt_hours + ", Pay Rate: " + pt_payRate;
    }

}
