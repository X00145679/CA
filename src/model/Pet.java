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
@Table(name = "PET")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")

@SequenceGenerator(name = "petid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "petid_seq")
    private String petname;
    private String petDOB;
    private String petDatePurchased;
    private int breedid,ownid;
    
    
}
