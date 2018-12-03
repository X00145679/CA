package test;

import db.ShopOperations;
import javax.persistence.*;
import java.util.Scanner;
import db.PersistenceOperations;

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
        so.dropEmployeeSequence();

        so.createPetSequence();
        so.createBreedSequence();
        so.createFoodSequence();
        so.createEmployeeSequence();

        so.dropPetTable();
        so.dropBreedTable();
        so.dropFoodTable();
        so.dropEmployeeTable();
        so.dropPetFoodTable();

        so.createBreedTable();
        so.createFoodTable();
        so.createEmployeeTable();
        so.createPetTable();
        so.createPetFoodTable();

        so.fillBreedTable();
        so.fillFoodTable();
        so.fillEmployeeTable();
        so.fillPetTable();

        PersistenceOperations po = new PersistenceOperations();

        while (true) {
            //Show Methods
            System.out.println("Please press 1 to show all pets");
            System.out.println("Please press 2 to show all owners");
            System.out.println("Please press 3 to show all breed");
            System.out.println("Please press 4 to show all food");
            
            //Add Methods
            System.out.println("Please press 5 to add a new Employee");
            System.out.println("Please press 6 to add a new Pet");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    po.showPets();
                    break;
                case 2:
                    po.showEmployees();
                    break;
                case 3:
                    po.showBreeds();
                    break;
                case 4:
                    po.showFood();
                    break;
                    
                case 5:
                    System.out.println("Please enter the name of the Employee "
                            + "you wish to add");
                    String name = in.nextLine();
                    System.out.println("Please enter the phone number of the Employee "
                            + "you wish to add");
                    String pNum = in.nextLine();
                    System.out.println("Please enter the pay rate of the Employee "
                            + "you wish to add");
                    double payRate = in.nextDouble();
                    System.out.println("Please enter the hours of the Employee "
                            + "you wish to add");
                    int hours = in.nextInt();
                    po.addEmployee(name, pNum, payRate, hours);
                    break;
                case 6:
                    po.addPet();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid Option entered");
            }
        }

    }
}
