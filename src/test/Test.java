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
        so.dropFTtable();
        so.dropPTtable();
        
        so.createBreedTable();
        so.createFoodTable();
        so.createEmployeeTable();
        so.createPetTable();
        so.createPetFoodTable();
        so.createPTtable();
        so.createFTtable();
        
        so.fillBreedTable();
        so.fillFoodTable();
        so.fillEmployeeTable();
        so.fillPetTable();
        so.fillPTtable();
        so.fillFTtable();
        
        PersistenceOperations po = new PersistenceOperations();
        
        while (true) {
            //Show Methods
            System.out.println("Show:");
            System.out.println("\nPlease press 1 to SHOW all PETS");
            System.out.println("Please press 2 to SHOW all EMPLOYEES");
            System.out.println("Please press 3 to SHOW all BREEDS");
            System.out.println("Please press 4 to SHOW all FOOD");
            System.out.println("Please press 5 to SHOW all FULLTIME EMPLOYEES");
            System.out.println("Please press 6 to SHOW all PART TIME EMPLOYEES\n");

            //Add Methods
            System.out.println("Add:");
            System.out.println("Please press 7 to ADD a new EMPLOYEE");
            System.out.println("Please press 8 to ADD a new PET");
            System.out.println("Please prees 9 to ADD new FOOD\n");

            //Remove Methods
            System.out.println("Remove:");
            System.out.println("Please press 10 to REMOVE a PET");
            System.out.println("Please press 11 to REMOVE an EMPLOYEE\n");

            //Update
            System.out.println("Update:");
            System.out.println("Please press 12 to UPDATE a PET");
            System.out.println("Please press 13 to UPDATE an SHOP EMPLOYEE");
            System.out.println("Please press 14 to UPDATE a FOOD\n");

            //Query
            System.out.println("Query:");
            System.out.println("Please press 15 to VIEW PETFOOD");
            System.out.println("Please press 16 to ADD a new PETFOOD\n");
            //End
            System.out.println("Please press 17 to EXIT");
            
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
                    po.showFullTime();
                    break;
                case 6:
                    po.showPartTime();
                
                case 7:
                    System.out.println("Please enter the name of the Employee "
                            + "you wish to add");
                    String name = in.nextLine();
                    System.out.println("Please enter the phone number of the Employee");
                    String pNum = in.nextLine();
                    
                    System.out.println("Please enter the type of Employee (PT or FT)");
                    String type = in.nextLine();
                    
                    if (type.equals("FT")) {
                        System.out.println("Please enter the salary of the FullTime Employee");
                        double salary = in.nextDouble();
                        po.addFullTime(name, pNum, salary);
                    } else if (type.equals("PT")) {
                        System.out.println("Please enter the pay rate of the PartTime Employee");
                        double payRate = in.nextDouble();
                        System.out.println("Please enter the hours of the PartTime Employee ");
                        int hours = in.nextInt();
                        po.addPartTime(name, pNum, payRate, hours);
                    }
                    break;

                
                case 8:
                    System.out.println("Please enter the name of the Pet "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the DOB YEAR of the Pet ");
                    int year = in.nextInt();
                    System.out.println("Please enter the DOB MONTH of the Pet ");
                    int month = in.nextInt();
                    System.out.println("Please enter the DOB DAY of the Pet ");
                    int day = in.nextInt();
                    Calendar pdate = Calendar.getInstance();
                    pdate.set(year, month, day);
                    
                    
                    
                    System.out.println("Please enter the PRICE of the Pet ");
                    double price = in.nextDouble();
                    System.out.println("Please enter the breed of the Pet");
                    int bid = in.nextInt();
                    System.out.println("Please enter the Employee in charge of the Pet");
                    int eid = in.nextInt();
                    po.addPet(name, pdate, price, bid, eid);
                    break;
                case 9:
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
                    type = in.nextLine();
                    
                    po.addFood(name, price, servings, type);
                    break;
                case 10:
                    System.out.println("Enter the id of the Pet "
                            + "you wish to remove");
                    int id = in.nextInt();
                    po.removePet(id);
                    break;
                case 11:
                    System.out.println("Enter the id of the EMPLOYEE "
                            + "you wish to remove");
                    id = in.nextInt();
                    po.removeEmployee(id);
                    break;
                case 12:
                    System.out.println("Please enter the ID of the CARER Employee "
                            + "you wish to update");
                    id = in.nextInt();
                    
                    System.out.println("Please enter the new SALARY of the Shop Employee "
                            + "you wish to update");
                    double salary = in.nextDouble();
                    po.updateFullTime(id, salary);
                case 13:
                    System.out.println("Please enter the ID of the Employee "
                            + "you wish to update");
                    id = in.nextInt();
                    System.out.println("Please enter the type of Employee");
                    type = in.nextLine();
                    if (type.equals("PT")) {
                        System.out.println("Please enter the pay rate of the Part-time Employee ");
                        double payRate = in.nextDouble();
                        System.out.println("Please enter the hours of the Part-time Employee");
                        int hours = in.nextInt();
                        po.updatePartTime(id, payRate, hours);
                    } else if (type.equals("FT")) {
                        System.out.println("Please enter the new salary of the fulltime Employee");
                        salary = in.nextDouble();
                        po.updateFullTime(id, salary);
                    }
                    break;
                case 14:
                    System.out.println("Please enter the ID of the Food "
                            + "you wish to update");
                    id = in.nextInt();
                    System.out.println("Please enter the PRICE of the Food "
                            + "you wish to update");
                    price = in.nextDouble();
                    System.out.println("Please enter the SERVINGS of the Food "
                            + "you wish to update");
                    servings = in.nextInt();
                    
                    po.updateFood(id, servings, price);
                    break;
                
                case 15:
                    System.out.println("Please enter the ID of the PET whose FOODD "
                            + "you wish to see");
                    id = in.nextInt();
                    po.veiwPetFood(id);
                    break;
                case 16:
                    System.out.println("Please enter the ID of the PET whose FOODD "
                            + "you wish to change");
                    int pid = in.nextInt();
                    System.out.println("Please enter the ID of the new FOOD  ");
                    int fid = in.nextInt();
                    po.addPetFood(pid, fid);
                    break;
                
                case 17:
                    po.close();
                    so.closeDB();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option entered");
            }
        }
    }
}
