package test;

import db.ShopOperations;
import javax.persistence.*;
import java.util.Scanner;
import db.PersistenceOperations;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author David Bird x00148542 David Browne x00145679
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

        so.dropPetTable();
        so.dropBreedTable();
        so.dropFoodTable();
        so.dropEmployeeTable();
        so.dropPetFoodTable();
        so.dropFTtable();
        so.dropPTtable();

        so.createPetSequence();
        so.createBreedSequence();
        so.createFoodSequence();
        so.createEmployeeSequence();

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
        so.fillPETFOODTable();

        PersistenceOperations po = new PersistenceOperations();

        while (true) {
            //Show Methods
            System.out.println("\nShow:");
            System.out.println("Please press 1 to SHOW all PETS");
            System.out.println("Please press 2 to SHOW all EMPLOYEES");
            System.out.println("Please press 3 to SHOW all BREEDS");
            System.out.println("Please press 4 to SHOW all FOOD");
            System.out.println("Please press 5 to SHOW all FULLTIME EMPLOYEES");
            System.out.println("Please press 6 to SHOW all PART TIME EMPLOYEES\n");

            //Add Methods
            System.out.println("Add:");
            System.out.println("Please press 7 to ADD a new PET");
            System.out.println("Please press 8 to ADD a new EMPLOYEE");
            System.out.println("Please press 9 to ADD a new BREED");
            System.out.println("Please prees 10 to ADD new FOOD\n");

            //Remove Methods
            System.out.println("Remove:");
            System.out.println("Please press 11 to REMOVE a PET");
            System.out.println("Please press 12 to REMOVE an EMPLOYEE\n");

            //Update
            System.out.println("Update:");
            System.out.println("Please press 13 to UPDATE a PET");
            System.out.println("Please press 14 to UPDATE an EMPLOYEE");
            System.out.println("Please press 15 to UPDATE a FOOD\n");

            //Query
            System.out.println("Query:");
            System.out.println("Please press 16 to VIEW PETFOOD");
            System.out.println("Please press 17 to ADD a new PETFOOD");
            System.out.println("Please press 18 to VIEW PET CARER EMPLOYEE\n");

            //End
            System.out.println("Press 19 to exit");
            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                //Shows
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
                    break;
                //Adds
                case 7:
                    System.out.println("Please enter the name of the PET "
                            + "you wish to add");
                    String name = in.nextLine();
                    System.out.println("Please enter the DOB YEAR of the PET ");
                    int year = in.nextInt();
                    System.out.println("Please enter the DOB MONTH of the PET ");
                    int month = in.nextInt();
                    System.out.println("Please enter the DOB DAY of the PET ");
                    int day = in.nextInt();
                    Calendar pdate = Calendar.getInstance();
                    pdate.set(year, month, day);

                    System.out.println("Please enter the PRICE of the PET ");
                    double price = in.nextDouble();
                    System.out.println("Please enter the BREED ID of the PET");
                    int bid = in.nextInt();
                    System.out.println("Please enter the EMPLOYEE ID in charge of the PET");
                    int eid = in.nextInt();
                    po.addPet(name, pdate, price, bid, eid);
                    break;
                case 8:
                    System.out.println("Please enter the NAME of the EMPLOYEE "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the PHONE NUMBER of the EMPLOYEE");
                    String pNum = in.nextLine();

                    System.out.println("Please enter the TYPE of EMPLOYEE (PT or FT)");
                    String type = in.nextLine();
                    type.toUpperCase();

                    if (type.equals("FT")) {
                        System.out.println("Please enter the SALARY of the FULL-TIME EMPLOYEE");
                        double salary = in.nextDouble();
                        po.addFullTime(name, pNum, salary);
                    } else if (type.equals("PT")) {
                        System.out.println("Please enter the PAYRATE of the PART TIME EMPLOYEE ");
                        double payRate = in.nextDouble();
                        System.out.println("Please enter the HOURS of the PART TIME EMPLOYEE ");
                        int hours = in.nextInt();
                        po.addPartTime(name, pNum, payRate, hours);
                    }
                    break;
                case 9:
                    System.out.println("Please enter the NAME of the new BREED "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the SIZE of the new BREED");
                    String size = in.nextLine();
                    po.addBreed(name, size);
                    break;
                case 10:
                    System.out.println("Please enter the NAME of the FOOD "
                            + "you wish to add");
                    name = in.nextLine();
                    System.out.println("Please enter the PRICE of the FOOD ");
                    price = in.nextDouble();
                    System.out.println("Please enter the SERVINGS of the FOOD ");
                    int servings = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the TYPE of the FOOD ");
                    String type1 = in.nextLine();

                    po.addFood(name, price, servings, type1);
                    break;
                //Removes
                case 11:
                    System.out.println("Enter the ID of the PET "
                            + "you wish to remove");
                    int id = in.nextInt();
                    po.removePet(id);
                    break;
                case 12:
                    System.out.println("Enter the ID of the EMPLOYEE "
                            + "you wish to remove");
                    id = in.nextInt();
                    po.removeEmployee(id);
                    break;
                //Updates
                case 13:
                    System.out.println("Enter the ID of the PET you wish to update");
                    id = in.nextInt();
                    System.out.println("Enter the new PRICE of the PET");
                    price = in.nextDouble();
                    po.updatePet(id, price);
                    break;
                case 14:
                    System.out.println("Please enter the ID of the EMPLOYEE "
                            + "you wish to update");
                    id = in.nextInt();
                    in.nextLine();
                    System.out.println("Please enter the TYPE of EMPLOYEE");
                    type = in.nextLine();
                    if (type.equals("PT")) {
                        System.out.println("Please enter the PAY RATE of the PART TIME EMPLOYEE ");
                        double payRate = in.nextDouble();
                        System.out.println("Please enter the HOURS of the PART TIME EMPLOYEE");
                        int hours = in.nextInt();
                        po.updatePartTime(id, payRate, hours);
                    } else if (type.equals("FT")) {
                        System.out.println("Please enter the new SALARY of the FULL-TIME EMPLOYEE");
                        double salary = in.nextDouble();
                        po.updateFullTime(id, salary);
                    }
                    break;
                case 15:
                    System.out.println("Please enter the ID of the FOOD "
                            + "you wish to update");
                    id = in.nextInt();
                    System.out.println("Please enter the PRICE of the FOOD ");
                    price = in.nextDouble();
                    System.out.println("Please enter the SERVINGS of the FOOD ");
                    servings = in.nextInt();

                    po.updateFood(id, servings, price);
                    break;
                //Querys
                case 16:
                    System.out.println("Please enter the ID of the PET whose FOOD "
                            + "you wish to see");
                    id = in.nextInt();
                    po.veiwPetFood(id);
                    break;
                case 17:
                    System.out.println("Please enter the ID of the PET whose FOOD "
                            + "you wish to change");
                    int pid = in.nextInt();
                    System.out.println("Please enter the ID of the new FOOD  ");
                    int fid = in.nextInt();
                    po.addPetFood(pid, fid);
                    break;
                case 18:
                    System.out.println("Please enter the ID of the EMPLOYEE whose PETS CARER "
                            + "you wish to see");
                    id = in.nextInt();
                    po.veiwPetEmployee(id);
                    break;
                case 19:
                    po.close();
                    so.closeDB();
                    System.exit(0);
                default:
                    System.out.println("Invalid Option entered");
            }
        }
    }
}
