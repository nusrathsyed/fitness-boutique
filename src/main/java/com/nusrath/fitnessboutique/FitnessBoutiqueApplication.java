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
	CommandLineRunner runner(InventoryRepository inventoryRepo, MongoTemplate mongoTemplate, WarehouseRepository warehouseRepository) {
		return args -> {

			//Feature 1: Create warehouses/locations

			Warehouse warehouse = new Warehouse(
					"Fine Imports Warehouse",
					"Canada"
			);
			Warehouse warehouseTwo = new Warehouse(
					"Shifaa Nutrition Warehouse",
					"USA"
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


			//READ
			//SAVE - INSERT
			//TODO - set this to a var
			//inventoryRepo.insert(inventory);
			//inventoryRepo.insert(inventoryTwo);
			System.out.println(inventoryRepo.findAll());


			//UPDATE
			Query query = new Query();
			query.addCriteria(Criteria.where("productNumber").is("123"));
			Update update = new Update();
			update.set("productNumber", "153");
			mongoTemplate.updateFirst(query, update, Inventory.class);


			//DELETE
			//TODO - delete an inventory
			inventoryRepo.deleteById("627ffac1710c144fa7b42059");
			//TODO - do another read
			System.out.println(inventoryRepo.findAll());


			//inventory (t-shirts, multi-vitamins, protein powder, pants)
			//warehouse (nutrition warehouse, clothing warehouses)


			//TODO - assign inventory to specific locations
//			inventoryRepo.findInventoryById("627ffac1710c144fa7b42059");



		};

	}
}


