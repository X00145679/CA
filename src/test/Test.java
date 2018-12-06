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
        so.dropEmpCarerTable();
        so.dropEmpShopTable();

        so.createBreedTable();
        so.createFoodTable();
        so.createEmployeeTable();
        so.createPetTable();
        so.createPetFoodTable();
        so.createEMPCARERtable();
        so.createEmpShoptable();

        so.fillBreedTable();
        so.fillFoodTable();
        so.fillEmployeeTable();
        so.fillPetTable();
        so.fillEMPCARERtable();
        so.fillEMPSHOPtable();

        PersistenceOperations po = new PersistenceOperations();

        while (true) {
            //Show Methods
            System.out.println("\nPlease press 1 to SHOW all PETS");
            System.out.println("Please press 2 to SHOW all EMPLOYEES");
            System.out.println("Please press 3 to SHOW all BREEDS");
            System.out.println("Please press 4 to SHOW all FOOD");
            System.out.println("Please press 5 to SHOW all EMPLOYEE CARERS");
            System.out.println("Please press 6 to SHOW all SHOP EMPLOYEES");

            //Add Methods
            System.out.println("Please press 7 to ADD a new CARER EMPLOYEE");
            System.out.println("Please press 8 to ADD a new SHOP EMPLOYEE");
            System.out.println("Please press 9 to ADD a new PET");
            System.out.println("Please prees 10 to ADD new FOOD");

            //Remove Methods
            System.out.println("Please press 11 to REMOVE a PET");
            System.out.println("Please press 12 to REMOVE an EMPLOYEE");

            //Update
            System.out.println("Please press 13 to UPDATE a PET");
            System.out.println("Please press 14 to UPDATE an SHOP EMPLOYEE");
            System.out.println("Please press 15 to UPDATE a FOOD\n");

            //Query
            System.out.println("Please press 16 to VIEW PETFOOD");
            System.out.println("Please press 17 to ADD a new PETFOOD");
            //End
            System.out.println("Please press 18 to EXIT");

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
                    po.showEmpCarer();
                    break;
                case 6:
                    po.showEmpShop();

                case 7:
//                    System.out.println("Please enter the name of the Employee "
//                            + "you wish to add");
//                    String name = in.nextLine();
//                    System.out.println("Please enter the phone number of the Employee "
//                            + "you wish to add");
//                    String pNum = in.nextLine();
//                    System.out.println("Please enter the pay rate of the Employee "
//                            + "you wish to add");
//                    double payRate = in.nextDouble();
//                    System.out.println("Please enter the hours of the Employee "
//                            + "you wish to add");
//                    int hours = in.nextInt();
//                    po.addEmployee(name, pNum, payRate, hours);

                    System.out.println("Please enter the name of the Carer "
                            + "you wish to add");
                    String name = in.nextLine();
                    System.out.println("Please enter the phone number of the Carer "
                            + "you wish to add");
                    String pNum = in.nextLine();
                    System.out.println("Please enter the salary of the Carer "
                            + "you wish to add");
                    double salary = in.nextDouble();

                    po.addEmpCarer(name, pNum, salary);
                    break;
                case 8:
                    System.out.println("Please enter the name of the Shop Employee "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the phone number of the Shop Employee "
                            + "you wish to add");
                    pNum = in.nextLine();
                    System.out.println("Please enter the pay rate of the Shop Employee "
                            + "you wish to add");
                    double payRate = in.nextDouble();
                    System.out.println("Please enter the hours of the Shop Employee "
                            + "you wish to add");
                    int hours = in.nextInt();
                    po.addEmpShop(name, pNum, payRate, hours);
                    break;

                case 9:
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
                    pdate.set(year, month, day);

                    System.out.println("Please enter the PRICE of the Pet "
                            + "you wish to add");
                    double price = in.nextDouble();

                    po.addPet(name, pdate, price);
                    break;
                case 10:
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

                    po.addFood(name, price, servings, type);
                    break;
                case 11:
                    System.out.println("Enter the id of the Pet "
                            + "you wish to remove");
                    int id = in.nextInt();
                    po.removePet(id);
                    break;
                case 12:
                    System.out.println("Enter the id of the EMPLOYEE "
                            + "you wish to remove");
                    id = in.nextInt();
                    po.removeEmployee(id);
                    break;
                case 13:
                    System.out.println("Please enter the ID of the CARER Employee "
                            + "you wish to update");
                    id = in.nextInt();

                    System.out.println("Please enter the new SALARY of the Shop Employee "
                            + "you wish to update");
                    salary = in.nextDouble();
                    po.updateEmpCarer(id, salary);
                case 14:
//                    System.out.println("Please enter the ID of the Employee "
//                            + "you wish to update");
//                    int ID = in.nextInt();
//                    
//                    System.out.println("Please enter the pay rate of the Employee "
//                            + "you wish to update");
//                    double payRate1 = in.nextDouble();
//                    System.out.println("Please enter the hours of the Employee "
//                            + "you wish to update"); 
//                    int hours1 = in.nextInt();
//                    po.updateEmployee(ID, payRate1, hours1);

                    System.out.println("Please enter the ID of the Shop Employee "
                            + "you wish to update");
                    id = in.nextInt();

                    System.out.println("Please enter the pay rate of the Shop Employee "
                            + "you wish to update");
                    payRate = in.nextDouble();
                    System.out.println("Please enter the hours of the Shop Employee "
                            + "you wish to update");
                    hours = in.nextInt();
                    po.updateEmpShop(id, payRate, hours);

                    break;
                case 15:
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
                    
                case 16:
                    System.out.println("Please enter the ID of the PET whose FOODD "
                            + "you wish to see");
                    id = in.nextInt();
                    po.veiwPetFood(id);
                    break;
                case 17:
                    System.out.println("Please enter the ID of the PET whose FOODD "
                            + "you wish to change");
                    int pid = in.nextInt();
                    System.out.println("Please enter the ID of the new FOOD  ");
                    int fid = in.nextInt();
                    po.addPetFood(pid, fid);
                    break;
                    

                case 18:
                    po.close();
                    so.closeDB();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option entered");
            }
        }
    }
}
