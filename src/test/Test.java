package test;

import db.ShopOperations;
import javax.persistence.*;
import java.util.Scanner;
import db.PersistenceOperations;
import java.util.Calendar;
import java.util.Locale;

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
            System.out.println("\nPlease press 1 to show all pets");
            System.out.println("Please press 2 to show all Employees");
            System.out.println("Please press 3 to show all breeds");
            System.out.println("Please press 4 to show all food");
            
            //Add Methods
            System.out.println("Please press 5 to add a new Employee");
            System.out.println("Please press 6 to add a new Pet");
            System.out.println("Please prees 7 to add new Food");
            
            //Remove Methods
            System.out.println("Please press 8 to remove a Pet");
            System.out.println("Please press 9 to remove an Employee");
            
            //Update
            System.out.println("Please press 10 to update a Pet");
            System.out.println("Please press 11 to update an Employee\n");
            
            //Query
           
            //End
            System.out.println("Please press 12 to EXIT");

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
                    System.out.println("Please enter the name of the Pet "
                            + "you wish to add");
                    name = in.nextLine();
                    
                    System.out.println("Please enter the DOB YEAR of the Pet "
                            + "you wish to add");
                    int year = in.nextInt();
                    System.out.println("Please enter the DOB MONTH of the Pet "
                            + "you wish to add");
                    int month = in.nextInt();
                    System.out.println("Please enter the DOB DAY of the Pet "
                            + "you wish to add");
                    int day = in.nextInt();
                    Calendar pdate = Calendar.getInstance();
                    pdate.set(year,month, day);
                    
                    System.out.println("Please enter the PRICE of the Pet "
                            + "you wish to add");
                    double price = in.nextDouble();
                    
                    po.addPet(name, pdate, price);
                    break;
                case 7:
                    System.out.println("Please enter the NAME of the Food "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the PRICE of the Food "
                            + "you wish to add");
                    price = in.nextDouble();
                    System.out.println("Please enter the SERVINGS of the Food "
                            + "you wish to add");
                    int servings = in.nextInt();
                    System.out.println("Please enter the TYPE of the Food "
                            + "you wish to add");
                    String type = in.nextLine();
                    
                    po.addFood(name,price,servings,type);
                    break;
                case 8:
                    System.out.println("Enter the id of the Pet "
                            + "you wish to remove");
                    int id = in.nextInt();
                    po.removePet(id);
                    break;
                case 9:
                    System.out.println("Enter the id of the EMPLOYEE "
                            + "you wish to remove");
                    id = in.nextInt();
                    po.removeEmployee(id);
                    break;
                case 10:
                    
                    break;
                case 11:
                    
                    break;
                case 12:
                    po.close();
                    so.closeDB();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option entered");
            }
        }

    }
}