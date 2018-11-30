package test;

import db.ShopOperations;
import javax.persistence.*;

/**
 *
 * @author David Bird
 */
public class Test {
    
    public static void main(String[] args) {
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
        
        so.createPetTable();
        so.createBreedTable();
        so.createFoodTable();
        so.createOwnerTable();
        so.createPetFoodTable();
    }
}
