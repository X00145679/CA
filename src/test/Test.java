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

        PersistenceOperations po = new PersistenceOperations();

        while (true) {
            System.out.println("Please press 1 to show all pets");
            System.out.println("Please press 2 to show all owners");
            System.out.println("Please press 3 to show all breed");
            System.out.println("Please press 4 to show all food");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    po.showPets();
                    break;
                case 2:
                    po.showOwners();
                    break;
                case 3:
                    po.showBreeds();
                    break;
                case 4:
                    po.showFood();
                    break;
                case 5:
                    System.out.println("Please enter the name of the owner "
                            + "you wish to add");
                    String name = in.nextLine();
                    System.out.println("Please enter the address of the owner "
                            + "you wish to add");
                    String address = in.nextLine();
                    System.out.println("Please enter the phone number of the owner "
                            + "you wish to add");
                    String pNum = in.nextLine();
                    po.addOwner(name, address, pNum);
                    break;
                default:
                    System.out.println("Invalid Option entered");
            }
        }

    }
}
