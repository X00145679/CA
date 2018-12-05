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
            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
            ods.setUser("x00148542");
            ods.setPassword("db21Feb99");
            
            // Home Oracle XE
//            ods.setURL("jdbc:oracle:thin:HR/pmagee@localhost:1521:XE");
//            ods.setUser("hr");
//            ods.setPassword("passhr");

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
            System.out.println("PET SEQUENCE dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPetSequence() {
        //Creating Pet
        try {
            String createseq1 = "create sequence petid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("PET Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with PET Sequence " + ex.getMessage());
        }
    }

    //Breed Sequence
    public void dropBreedSequence() {
        try {
            String s2 = "drop sequence breedid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("BREED Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createBreedSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence breedid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("BREED Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with BREED Sequence " + ex.getMessage());
        }
    }

    //Employee Sequence
    public void dropEmployeeSequence() {
        try {
            String s2 = "drop sequence empid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("EMPLOYEE Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createEmployeeSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence empid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("EMPLOYEE Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with EMPLOYEE Sequence " + ex.getMessage());
        }
    }

    //Food Sequence
    public void dropFoodSequence() {
        try {
            String s2 = "drop sequence foodid_seq";
            pstmt = conn.prepareStatement(s2);
            pstmt.executeUpdate();
            System.out.println("FOOD Sequence dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFoodSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence foodid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("FOOD Sequence created");
        } catch (SQLException ex) {
            System.out.print("Problem with FOOD Sequence " + ex.getMessage());
        }
    }

    //Tables
    //Pet Table
    public void dropPetTable() {
        System.out.println("Checking for existence of PET table");
        try {
            String s1 = "DROP TABLE PET CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("PET  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPetTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PET (petid NUMBER PRIMARY KEY NOT NULL,"
                    + "p_name VARCHAR2(255),"
                    + "p_DOB DATE,"
                    + "p_price NUMBER,"
                    + "breedid NUMBER,"
                    + "empid NUMBER,"
                    + "FOREIGN KEY (breedid) REFERENCES BREED (breedid) ON DELETE CASCADE,"
                    + "FOREIGN KEY (empid) REFERENCES  EMPLOYEE (empid) ON DELETE CASCADE)";
    

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE PET created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Pet table" + ex.getMessage());
        }
    }

    //Owner Table
    public void dropEmployeeTable() {
        System.out.println("Checking for existence of Employee table");
        try {
            String s1 = "DROP TABLE EMPLOYEE CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("EMPLOYEE table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createEmployeeTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE EMPLOYEE (empid NUMBER PRIMARY KEY NOT NULL,"
                    + "e_name VARCHAR2(255),"
                    + "e_pNum VARCHAR2(255),"
                    + "e_payRate NUMBER,"
                    + "e_hours NUMBER)";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE EMPLOYEE created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "EMPLOYEE table" + ex.getMessage());
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

    public void createBreedTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE BREED (breedid NUMBER PRIMARY KEY NOT NULL,"
                    + "b_name VARCHAR2(255),"
                    + "b_exp_years NUMBER,"
                    + "b_size VARCHAR2(255))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE BREED created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "Breed table" + ex.getMessage());
        }
    }

    public void dropFoodTable() {
        System.out.println("Checking for existence of FOOD  table");
        try {
            String s1 = "DROP TABLE FOOD CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("FOOD  table dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFoodTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE FOOD (foodid NUMBER PRIMARY KEY NOT NULL,"
                    + "f_name VARCHAR2(50),"
                    + "f_price NUMBER,"
                    + "f_servings NUMBER,"
                    + "f_type VARCHAR2(10))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE FOOD created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "FOOD table" + ex.getMessage());
        }
    }

    public void dropPetFoodTable() {
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
    public void createPetFoodTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PETFOOD (petid NUMBER,"
                    + "foodid NUMBER,"
                    + "PRIMARY KEY (petid, foodid),"
                    + "FOREIGN KEY (petid) REFERENCES PET (petid) ON DELETE CASCADE,"
                    + "FOREIGN KEY (foodid) REFERENCES FOOD (foodid) ON DELETE CASCADE)";

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
            String sql = "INSERT INTO PET VALUES(petid_seq.nextVal,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Bob");
            pstmt.setDate(2, Date.valueOf("2016-01-30"));
            pstmt.setDouble(3, 120.0);
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();

            pstmt.setString(1, "Doge");
            pstmt.setDate(2, Date.valueOf("2017-03-20"));
            pstmt.setDouble(3, 140.0);
            pstmt.setInt(4, 2);
            pstmt.setInt(5, 2);
            pstmt.executeUpdate();

            pstmt.setString(1, "Rocky");
            pstmt.setDate(2, Date.valueOf("2017-05-23"));
            pstmt.setDouble(3, 80.50);
            pstmt.setInt(4, 3);
            pstmt.setInt(5, 3);
            pstmt.executeUpdate();

            pstmt.setString(1, "Aaron");
            pstmt.setDate(2, Date.valueOf("2018-01-30"));
            pstmt.setDouble(3, 45.99);
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 4);
            pstmt.executeUpdate();

            pstmt.setString(1, "Rex");
            pstmt.setDate(2, Date.valueOf("2018-01-21"));
            pstmt.setDouble(3, 130.0);
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 4);
            pstmt.executeUpdate();

            pstmt.setString(1, "Ron");
            pstmt.setDate(2, Date.valueOf("2015-03-21"));
            pstmt.setDouble(3, 40.0);
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 4);
            pstmt.executeUpdate();

            pstmt.setString(1, "Dave");
            pstmt.setDate(2, Date.valueOf("2015-07-11"));
            pstmt.setDouble(3, 12.2);
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();

            System.out.println("Pet Table filled");
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "PET table" + ex.getMessage());
        }
    }

    // Fill Owner Table
    public void fillEmployeeTable() {
        try {
            String sql = "INSERT INTO EMPLOYEE VALUES(empid_seq.nextVal,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Dave");
            pstmt.setString(2, "0873974053");
            pstmt.setDouble(3, 10.50);
            pstmt.setInt(4, 20);
            pstmt.executeUpdate();

            pstmt.setString(1, "Matt");
            pstmt.setString(2, "0873544033");
            pstmt.setDouble(3, 10.50);
            pstmt.setInt(4, 15);
            pstmt.executeUpdate();

            pstmt.setString(1, "Steve");
            pstmt.setString(2, "0833344053");
            pstmt.setDouble(3, 8.40);
            pstmt.setInt(4, 10);
            pstmt.executeUpdate();

            pstmt.setString(1, "Mike");
            pstmt.setString(2, "0853684653");
            pstmt.setDouble(3, 12.80);
            pstmt.setInt(4, 26);
            pstmt.executeUpdate();

            pstmt.setString(1, "Scott");
            pstmt.setString(2, "0843678893");
            pstmt.setDouble(3, 12.80);
            pstmt.setInt(4, 28);
            pstmt.executeUpdate();

            System.out.println("Employee table filled");

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "EMPLOYEE table" + ex.getMessage());
        }
    }

    //Breed Table
    public void fillBreedTable() {
        try {
            String sql1 = "INSERT INTO BREED VALUES(breedid_seq.nextVal,?,?,?)";
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

            System.out.println("Breed Table filled");
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "BREED table" + ex.getMessage());
        }
    }

    //Food Table
    public void fillFoodTable() {
        try {
            String sql1 = "INSERT INTO FOOD VALUES(foodid_seq.nextVal,?,?,?,?)";
            pstmt = conn.prepareStatement(sql1);

            pstmt.setString(1, "AATU");
            pstmt.setDouble(2, 22.99);
            pstmt.setInt(3, 20);
            pstmt.setString(4, "Dry");
            pstmt.executeUpdate();

            pstmt.setString(1, "Applaws");
            pstmt.setDouble(2, 15.49);
            pstmt.setInt(3, 30);
            pstmt.setString(4, "Dry");
            pstmt.executeUpdate();

            pstmt.setString(1, "Pedigree Pouch");
            pstmt.setDouble(2, 4.99);
            pstmt.setInt(3, 12);
            pstmt.setString(4, "Wet");
            pstmt.executeUpdate();

            pstmt.setString(1, "Pedigree Classic");
            pstmt.setDouble(2, 26.99);
            pstmt.setInt(3, 24);
            pstmt.setString(4, "Wet");
            pstmt.executeUpdate();

            System.out.println("Food Table filled");

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "Food table" + ex.getMessage());
        }
    }
    
    public void fillPETFOODTable() {
        try {
            String sql = "INSERT INTO PETFOOD VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1,1);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,1);
            pstmt.setInt(2,4);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,2);
            pstmt.setInt(2,2);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,2);
            pstmt.setInt(2,4);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,3);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,4);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,4);
            pstmt.setInt(2,4);
            pstmt.executeUpdate();
            
            pstmt.setInt(1,5);
            pstmt.setInt(2,4);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "PETFOOD table" + ex.getMessage());
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
