package com.nusrath.fitnessboutique;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@SpringBootApplication
public class FitnessBoutiqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessBoutiqueApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(InventoryRepository inventoryRepo, MongoTemplate mongoTemplate, WarehouseRepository warehouseRepo) {
        return args -> {


            Warehouse warehouse = new Warehouse(
                    "Fine Fabrics",
                    "Canada"
            );
            Warehouse warehouseTwo = new Warehouse(
                    "Shifaa Nutrition Warehouse",
                    "USA"
            );
            Warehouse warehouseThree = new Warehouse(
                    "A&Z Warehouse",
                    "UK"
            );


            Inventory inventory = new Inventory(
                    "Contour Wide Leg Pants",
                    "$40",
                    "123",
                    Category.CLOTHING,
                    warehouse

            );

            Inventory inventoryTwo = new Inventory(
                    "Chocolate Halal Protein Powder",
                    "$50",
                    "502",
                    Category.NUTRITION,
                    warehouseTwo

            );
            Inventory inventoryThree = new Inventory(
                    "Oversize Long sleeve Top",
                    "$25",
                    "150",
                    Category.CLOTHING,
                    warehouseThree

            );
            Inventory inventoryFour = new Inventory(
                    "Vegan Multivitamin Gummies",
                    "$40",
                    "601",
                    Category.NUTRITION,
                    warehouseTwo

            );

            //CREATE Inventory Items
            System.out.println("Creating Items in the inventory...");
            inventoryRepo.insert(inventory);
            inventoryRepo.insert(inventoryTwo);
            inventoryRepo.insert(inventoryThree);
            inventoryRepo.insert(inventoryFour);

            //CREATE Warehouses/locations and assign inventory to specific locations
            System.out.println("Creating Warehouse and their location...");
            warehouseRepo.insert(warehouse);
            warehouseRepo.insert(warehouseTwo);
            warehouseRepo.insert(warehouseThree);

            //READ
            System.out.println("List all inventory items and assign them to specific warehouse locations");
            System.out.println(inventoryRepo.findAll());

            System.out.println("List all warehouses");
            System.out.println(warehouseRepo.findAll());


            //UPDATE
            Query query = new Query();
            query.addCriteria(Criteria.where("price").is("$40"));
            Update update = new Update();
            update.set("price", "$35");
            mongoTemplate.updateFirst(query, update, Inventory.class);
            System.out.println("Edit the price of certain items " + inventoryRepo.findAll());



            //DELETE
            inventoryRepo.deleteByProductNumber("601");
            inventoryRepo.deleteByProductNumber("502");
            System.out.println("List of all remaining inventory ");
            System.out.println(inventoryRepo.findAll());

            //DELETE DB TO SET UP FOR RERUN
            mongoTemplate.dropCollection("inventory");
            mongoTemplate.dropCollection("warehouse");
        };

    }
}


