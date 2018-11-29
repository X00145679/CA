package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author David
 */


@Entity
@Table(name = "OWNER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@SequenceGenerator(name = "ownid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownid_seq")
    private String o_name;
    private String o_address,o_pnum;
    private int ownid;
    
    public Owner(String o_name, String o_address, String o_pnum) {
        this.o_name = o_name;
        this.o_address = o_address;
        this.o_pnum = o_pnum;
    }

    public int getOwnid() {
        return ownid;
    }

    public void setOwnid(int ownid) {
        this.ownid = ownid;
    }

    public String getO_name() {
        return o_name;
    }

    public void setO_name(String o_name) {
        this.o_name = o_name;
    }

    public String getO_address() {
        return o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public String getO_pnum() {
        return o_pnum;
    }

    public void setO_pnum(String o_pnum) {
        this.o_pnum = o_pnum;
    }

    @Override
    public String toString() {
        return "Owner: " + "\n Owner ID: " + ownid + "Owner Name: " + o_name + "\n Address: " + o_address + "\n Phone Num: " + o_pnum;
    }

   
    
    
}
