package model;

import javax.persistence.*;
/**
 *
 * @author David
 */


@Entity
@Table(name = "OWNER")

@SequenceGenerator(name = "ownid_seq", initialValue = 1, allocationSize = 1)
@SuppressWarnings("SerializableClass")


public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownid_seq")
    private String o_name;
    private String o_address, o_pNum;
    private int ownid;

    public Owner() {
    }
    
    public Owner(String name, String address, String pnum) {
        this.o_name = name;
        this.o_address = address;
        this.o_pNum = pnum;
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
        return o_pNum;
    }

    public void setO_pnum(String o_pnum) {
        this.o_pNum = o_pnum;
    }

    @Override
    public String toString() {
        String s = String.format(" Owner Id: %1$-10d"
                + "Name: %2$-10s "
                + "Address: %3$-20s"
                + "Phone Num: %4$-10s",
                ownid, o_name, o_address, o_pNum);
        
        return s;
    }

}
