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
//            ods.setURL("jdbc:oracle:thin:@//10.10.2.7:1521/global1");
//            ods.setUser("x00145679");
//            ods.setPassword("db31Jan99");
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
            System.out.println("SEQUENCE PET dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPetSequence() {
        //Creating Pet
        try {
            String createseq1 = "create sequence petid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("SEQUENCE PET created");
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
            System.out.println("SEQUENCE BREED dropped");
        } catch (SQLException ex) {

        }
    }

    public void createBreedSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence breedid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("SEQUENCE BREED created");
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
            System.out.println("SEQUENCE EMPLOYEE dropped");
        } catch (SQLException ex) {

        }
    }

    public void createEmployeeSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence empid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("SEQUENCE EMPLOYEE created");
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
            System.out.println("SEQUENCE FOOD dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFoodSequence() {
        // Creating a sequence    
        try {
            String createseq1 = "create sequence foodid_seq increment by 1 start with 1";
            pstmt = conn.prepareStatement(createseq1);
            pstmt.executeUpdate();
            System.out.println("SEQUENCE FOOD created");
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
            System.out.println("TABLE PET dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPetTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE PET (petid NUMBER PRIMARY KEY NOT NULL,"
                    + "p_name VARCHAR2(30),"
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

    //Employee Table
    public void dropEmployeeTable() {
        System.out.println("Checking for existence of Employee table");
        try {
            String s1 = "DROP TABLE EMPLOYEE CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("TABLE EMPLOYEE dropped");
        } catch (SQLException ex) {

        }
    }

    public void createEmployeeTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE EMPLOYEE (empid NUMBER PRIMARY KEY NOT NULL,"
                    + "type VARCHAR2(5),"
                    + "e_name VARCHAR2(30),"
                    + "e_pNum VARCHAR2(30))";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE EMPLOYEE created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "EMPLOYEE table" + ex.getMessage());
        }
    }

    //EmpCarer Table
    public void dropFTtable() {
        System.out.println("Checking for existence of FULLTIME table");
        try {
            String s1 = "DROP TABLE FULLTIME CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("TABLE FULLTIME dropped");
        } catch (SQLException ex) {

        }
    }

    public void createFTtable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE FULLTIME (empid NUMBER PRIMARY KEY,"
                    + "ft_salary NUMBER,"
                    + "FOREIGN KEY (EMPID) REFERENCES EMPLOYEE (EMPID))";
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE FULLTIME created");

        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "FULLTIME table" + ex.getMessage());
        }
    }

    //PARTTIME Table
    public void dropPTtable() {
        System.out.println("Checking for existence of PARTTIME table");
        try {
            String s1 = "DROP TABLE PARTTIME CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("TABLE PARTTIME dropped");
        } catch (SQLException ex) {

        }
    }

    public void createPTtable() {
        // Create a Table           
        try {
            String sql1 = "CREATE TABLE PARTTIME(empid NUMBER PRIMARY KEY,"
                    + "pt_payRate NUMBER,"
                    + "pt_hours NUMBER,"
                    + "FOREIGN KEY (EMPID) REFERENCES EMPLOYEE (EMPID))";
            pstmt = conn.prepareStatement(sql1);
            pstmt.executeUpdate();
            System.out.println("TABLE PARTTIME created");

        } catch (SQLException ex) {

        }
    }

    //Breed Table
    public void dropBreedTable() {
        System.out.println("Checking for existence of Breed table");
        try {
            String s1 = "DROP TABLE BREED CASCADE CONSTRAINTS";
            pstmt = conn.prepareStatement(s1);
            pstmt.executeUpdate();
            System.out.println("TABLE BREED dropped");
        } catch (SQLException ex) {

        }
    }

    public void createBreedTable() {
        // Create a Table           
        try {
            String sql = "CREATE TABLE BREED (breedid NUMBER PRIMARY KEY NOT NULL,"
                    + "b_name VARCHAR2(30),"
                    + "b_size VARCHAR2(20))";

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
            System.out.println("TABLE FOOD dropped");
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
            System.out.println("TABLE PETFOOD dropped");
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
            pstmt.setInt(5, 5);
            pstmt.executeUpdate();

            pstmt.setString(1, "Ron");
            pstmt.setDate(2, Date.valueOf("2015-03-21"));
            pstmt.setDouble(3, 40.0);
            pstmt.setInt(4, 4);
            pstmt.setInt(5, 3);
            pstmt.executeUpdate();

            pstmt.setString(1, "Dave");
            pstmt.setDate(2, Date.valueOf("2015-07-11"));
            pstmt.setDouble(3, 12.2);
            pstmt.setInt(4, 1);
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();

            System.out.println("TABLE PET filled");
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "PET table" + ex.getMessage());
        }
    }

    // Fill Employee Table
    public void fillEmployeeTable() {
        try {
            String sql = "INSERT INTO EMPLOYEE VALUES(empid_seq.nextVal,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "PT");
            pstmt.setString(2, "Dave");
            pstmt.setString(3, "0873974053");
            pstmt.executeUpdate();

            pstmt.setString(1, "PT");
            pstmt.setString(2, "Matt");
            pstmt.setString(3, "0873544033");
            pstmt.executeUpdate();

            pstmt.setString(1, "PT");
            pstmt.setString(2, "Steve");
            pstmt.setString(3, "0833344053");
            pstmt.executeUpdate();

            pstmt.setString(1, "FT");
            pstmt.setString(2, "Mike");
            pstmt.setString(3, "0853684653");
            pstmt.executeUpdate();

            pstmt.setString(1, "FT");
            pstmt.setString(2, "Scott");
            pstmt.setString(3, "0843678893");
            pstmt.executeUpdate();

            System.out.println("TABLE EMPLOYEE filled");

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "EMPLOYEE table" + ex.getMessage());
        }
    }

    //Fill EmpCarer Table
    public void fillFTtable() {
        try {
            String sql = "INSERT INTO FULLTIME VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 4);
            pstmt.setDouble(2, 32000);
            pstmt.executeUpdate();

            pstmt.setInt(1, 5);
            pstmt.setDouble(2, 35000);
            pstmt.executeUpdate();

            System.out.println("TABLE FULLTIME filled");
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "FULLTIME table" + ex.getMessage());
        }
    }

    //Fill EmpShop Table
    public void fillPTtable() {
        try {
            String sql = "INSERT INTO PARTTIME VALUES(?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 1);
            pstmt.setDouble(2, 14);
            pstmt.setInt(3, 17);
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setDouble(2, 9.55);
            pstmt.setInt(3, 25);
            pstmt.executeUpdate();

            pstmt.setInt(1, 3);
            pstmt.setDouble(2, 10);
            pstmt.setInt(3, 32);
            pstmt.executeUpdate();

            System.out.println("TABLE PARTTIME filled");
        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "EMPSHOP table" + ex.getMessage());
        }
    }

    //Fill Breed Table
    public void fillBreedTable() {
        try {
            String sql1 = "INSERT INTO BREED VALUES(breedid_seq.nextVal,?,?)";
            pstmt = conn.prepareStatement(sql1);

            pstmt.setString(1, "Labrador");
            pstmt.setString(2, "Big");
            pstmt.executeUpdate();

            pstmt.setString(1, "Beagle");
            pstmt.setString(2, "Medium");
            pstmt.executeUpdate();

            pstmt.setString(1, "Rottweiller");
            pstmt.setString(2, "Big");
            pstmt.executeUpdate();

            pstmt.setString(1, "Pug");
            pstmt.setString(2, "Small");
            pstmt.executeUpdate();

            System.out.println("TABLE BREED filled");
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

            System.out.println("TABLE FOOD filled");

        } catch (SQLException ex) {
            System.out.println("SQL Exception filling "
                    + "Food table" + ex.getMessage());
        }
    }

    public void fillPETFOODTable() {
        try {
            String sql = "INSERT INTO PETFOOD VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

            pstmt.setInt(1, 1);
            pstmt.setInt(2, 4);
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setInt(2, 2);
            pstmt.executeUpdate();

            pstmt.setInt(1, 2);
            pstmt.setInt(2, 4);
            pstmt.executeUpdate();

            pstmt.setInt(1, 3);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

            pstmt.setInt(1, 4);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

            pstmt.setInt(1, 4);
            pstmt.setInt(2, 4);
            pstmt.executeUpdate();

            pstmt.setInt(1, 5);
            pstmt.setInt(2, 4);
            pstmt.executeUpdate();

            System.out.println("TABLE PETFOOD filled");

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
