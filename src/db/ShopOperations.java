/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class ShopOperations {

    private Connection conn;
    private PreparedStatement pstmt;

    public Connection openDB() {
        try {
            OracleDataSource ods = new OracleDataSource();

            // Tallaght
//             ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//             ods.setUser("x00148542");
//             ods.setPassword("db21Feb99");
            // Home Oracle XE
            ods.setURL("jdbc:oracle:thin:HR/pmagee@localhost:1521:XE");
            ods.setUser("hr");
            ods.setPassword("passhr");

            conn = ods.getConnection();
            System.out.println("connected.");
        } catch (SQLException e) {
            System.out.print("Unable to load driver " + e.getMessage());
        }
        return conn;
    }

    //Sequences
    //Pet Sequence
    public void dropPetSequence() {
        try {
            String s2 = "drop sequence petid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Pet Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPetSequence() {
        //Creating Pet
        try {
            String createseq1 = "create sequence petid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Pet Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Pet Sequence " + ex.getMessage());
        }
    }

    //Breed Sequence
    public void dropBreedSequence() {
        try {
            String s2 = "drop sequence breedid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Breed Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createBreedSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence breedid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Breed Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Breed Sequence " + ex.getMessage());
        }
    }

    //Owner Sequence
    public void dropOwnerSequence() {
        try {
            String s2 = "drop sequence ownid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Owner Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createOwnerSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence ownid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Owner Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Owner Sequence " + ex.getMessage());
        }
    }

    //Food Sequence
    public void dropFoodSequence() {
        try {
            String s2 = "drop sequence fid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("Food Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFoodSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence fid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("Food Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with Food Sequence " + ex.getMessage());
        }
    }

    //Tables
    //Pet Table
    public void dropPETTable() {
        System.out.println("Checking for existence of PET table");
        try {
            String s1 = "DROP TABLE PET CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("PET  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPETtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PET (petid NUMBER PRIMARY KEY NOT NULL,"
                    + "petname VARCHAR2(255),"
                    + "petDOB DATE,"
                    + "petDatePurchased DATE,"
                    + "breedid NUMBER,"
                    + "ownid NUMBER,"
                    + "FOREIGN KEY (bid)";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE PET created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Pet table" + ex.getMessage());
        }
    }

    //Owner Table
    public void dropOwnerTable() {
        System.out.println("Checking for existence of Owner table");
        try {
            String s1 = "DROP TABLE OWNER CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Owner  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createOwnertable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE OWNER (ownid NUMBER PRIMARY KEY NOT NULL,"
                    + "o_name VARCHAR2(255),"
                    + "o_address VARCHAR2(255),"
                    + "o_pnum VARCHAR2(255),";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE OWNER created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Owner table" + ex.getMessage());
        }
    }

    //Breed Table
    public void dropBreedTable() {
        System.out.println("Checking for existence of Breed table");
        try {
            String s1 = "DROP TABLE BREED CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("Breed  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createBreedtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE BREED (breedid NUMBER PRIMARY KEY NOT NULL,"
                    + "b_name VARCHAR2(255),"
                    + "b_exp_years NUMBERS,"
                    + "b_size VARCHAR2(255),";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE BREED created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Breed table" + ex.getMessage());
        }
    }

    public void dropFOODtable() {
        System.out.println("Checking for existence of FOOD  table");
        try {
            String s1 = "DROP TABLE FOOD CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("FOOD  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFOODtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE FOOD (fid NUMBER PRIMARY KEY NOT NULL,"
                    + "food_name VARCHAR2(50),"
                    + "food_price NUMBER,"
                    + "food_servings NUMBER,"
                    + "food_type VARCHAR2(10))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE FOOD created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "FOOD table" + ex.getMessage());
        }
    }

    public void dropPETFOODtable() {
        System.out.println("Checking for existence of PETFOOD  table");
        try {
            String s1 = "DROP TABLE PETFOOD CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("PETFOOD  table dropped");
        } catch (SQLException ex) {

        }
    }

    //PetFood Table
    public void createPETFOODtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PETFOOD (petid NUMBER,"
                    + "foodid NUMBER,"
                    + "PRIMARY KEY (petid, foodid),"
                    + "FOREIGN KEY (petid) REFERENCES PET (petid),"
                    + "FOREIGN KEY (foodid) REFERENCES FOOD (foodid))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE PETFOOD created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "PETFOOD table" + ex.getMessage());
        }
    }

    // Fill pet Table
    public void fillPetTable() {
        try {
            String sql = "INSERT INTO PET VALUES(petid_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Bob");
            pstmt.setDate(2, Date.valueOf("2016-01-31"));
            pstmt.setDate(3, Date.valueOf("2018-02-03"));
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();

            pstmt.setString(1, "Doge");
            pstmt.setDate(2, Date.valueOf("2017-03-20"));
            pstmt.setDate(3, Date.valueOf("2018-02-07"));
            pstmt.setInt(4, 2);
            pstmt.setInt(5, 2);
            pstmt.executeUpdate();

            pstmt.setString(1, "Rocky");
            pstmt.setDate(2, Date.valueOf("2017-05-23"));
            pstmt.setDate(3, Date.valueOf("2018-05-24"));
            pstmt.setInt(4, 3);
            pstmt.setInt(5, 3);
            pstmt.executeUpdate();

            pstmt.setString(1, "Aaron");
            pstmt.setDate(2, Date.valueOf("2018-01-31"));
            pstmt.setDate(3, Date.valueOf("2018-04-03"));
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 4);
            pstmt.executeUpdate();

            pstmt.setString(1, "Rex");
            pstmt.setDate(2, Date.valueOf("2018-01-21"));
            pstmt.setDate(3, Date.valueOf("2018-04-05"));
            pstmt.setInt(4, 5);
            pstmt.setInt(5, 5);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "PET table" + ex.getMessage());
        }
    }

    // Fill Owner Table
    public void fillOwnerTable() {
        try {
            String sql = "INSERT INTO OWNER VALUES(ownid_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Dave");
            pstmt.setString(2, "123 Lane rd");
            pstmt.setString(3, "0873974053");
            pstmt.executeUpdate();

            pstmt.setString(1, "Matt");
            pstmt.setString(2, "123 Plaza rd");
            pstmt.setString(3, "0873544033");
            pstmt.executeUpdate();

            pstmt.setString(1, "Steve");
            pstmt.setString(2, "13 place rd");
            pstmt.setString(3, "0833344053");
            pstmt.executeUpdate();

            pstmt.setString(1, "Mike");
            pstmt.setString(2, "123 Street");
            pstmt.setString(3, "0853684653");
            pstmt.executeUpdate();

            pstmt.setString(1, "Scott");
            pstmt.setString(2, "133 Lane rd");
            pstmt.setString(3, "0843678893");
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "MODULE15 table" + ex.getMessage());
        }
    }

    //Breed Table
    public void fillBreedTable() {
        try {
            String sql1 = "INSERT INTO BREED VALUES(breedid_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql1);

            pstmt.setString(1, "Labrador");
            pstmt.setInt(2, 12);
            pstmt.setString(3, "Big");
            pstmt.executeUpdate();

            pstmt.setString(1, "Beagle");
            pstmt.setInt(2, 13);
            pstmt.setString(3, "Medium");
            pstmt.executeUpdate();

            pstmt.setString(1, "Rottweiller");
            pstmt.setInt(2, 9);
            pstmt.setString(3, "Big");
            pstmt.executeUpdate();

            pstmt.setString(1, "Pug");
            pstmt.setInt(2, 14);
            pstmt.setString(3, "Small");
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "BREED table" + ex.getMessage());
        }
    }

    //Food Table
    public void fillFoodTable() {
        try {
            String sql1 = "INSERT INTO FOOD VALUES(foodid_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql1);

            pstmt.setString(1, "AATU");
            pstmt.setDouble(2, 22.99);
            pstmt.setInt(3, 20);
            pstmt.setString(2, "Dry");

            pstmt.setString(1, "Applaws");
            pstmt.setDouble(2, 15.49);
            pstmt.setInt(3, 30);
            pstmt.setString(2, "Dry");

            pstmt.setString(1, "Pedigree Pouch");
            pstmt.setDouble(2, 4.99);
            pstmt.setInt(3, 12);
            pstmt.setString(2, "Wet");

            pstmt.setString(1, "Pedigree Classic");
            pstmt.setDouble(2, 26.99);
            pstmt.setInt(3, 24);
            pstmt.setString(2, "Wet");

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "Food table" + ex.getMessage());
        }
    }
    
        public void closeDB() {
        try {
            pstmt.close();
            conn.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            System.out.println("Could not close connection " + ex.getMessage());
        }
        }
    

}
