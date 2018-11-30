package test;

import db.ShopOperations;
import javax.persistence.*;
import java.util.Scanner;
import db.PersistanceOperations;
/**
 *
 * @author David Bird
 */
public class Test {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ShopOperations so = new ShopOperations();
        
        so.openDB();
        so.dropPetSequence();
        so.dropBreedSequence();
        so.dropFoodSequence();
        so.dropOwnerSequence();
        
        so.createPetSequence();
        so.createBreedSequence();
        so.createFoodSequence();
        so.createOwnerSequence();
        
        so.dropPetTable();
        so.dropBreedTable();
        so.dropFoodTable();
        so.dropOwnerTable();
        so.dropPetFoodTable();
        
        so.createBreedTable();
        so.createFoodTable();
        so.createOwnerTable();
        so.createPetTable();
        so.createPetFoodTable();
        
        so.fillBreedTable();
        so.fillFoodTable();
        so.fillOwnerTable();
        so.fillPetTable();
        
        PersistanceOperations po = new PersistanceOperations();
        
        while (true) {
            System.out.println("Please press 1 to quit");
            System.out.println("Please press 2 to Update");
            System.out.println("Please press 3 to delete");
            System.out.println("Please press 4 to Query");
            
            int choice = in.nextInt();
            in.nextLine();
            
            switch (choice) {
                case 1:
                    so.closeDB();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Option entered");
            }
        }
    }
}
