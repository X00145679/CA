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
                    + "petname VARCHAR2(50),"
                    + "petDOB DATE,"
                    + "petDatePurchased,"
                    + "breedid NUMBER,"
                    + "ownid NUMBER,"
                    + "FOREIGN KEY (bid)";

            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("TABLE DEPARTMENT created");
        } catch (SQLException ex) {
            System.out.println("SQL Exception creating "
                    + "DEPARTMENT table" + ex.getMessage());
        }
    }
}
