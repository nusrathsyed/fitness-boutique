package com.nusrath.fitnessboutique;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
public class FitnessBoutiqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnessBoutiqueApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(InventoryRepository inventoryRepo, MongoTemplate mongoTemplate) {
		return args -> {
			Warehouse warehouse = new Warehouse(
					"TDot",
					"Canada",
					"Toronto"
			);

			String productNumber = "12345";

			Inventory inventory = new Inventory(
					"Contour Wide Leg Pants",
					"$40",
					productNumber,
					Category.CLOTHING,
					warehouse

			);

			// usingMongoTemplateAndQuery(inventoryRepo, mongoTemplate, productNumber, inventory);
			inventoryRepo.findInventoryByProductName(productNumber)
					.ifPresentOrElse(s -> System.out.println(s + " is over the stock quantity"), () -> {System.out.println("Inserting inventory " + inventory);
						inventoryRepo.insert(inventory);
					});
		};
	}

	private void usingMongoTemplateAndQuery(InventoryRepository inventoryRepo, MongoTemplate mongoTemplate, String productNumber, Inventory inventory) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productNumber").is(productNumber));

		List<Inventory> items = mongoTemplate.find(query, Inventory.class);

		if(items.size() > 100) {
			throw new IllegalStateException(
					"Not enough quantity of " + productNumber);
		}

		if(items.isEmpty()) {
			System.out.println("Inserting inventory " + inventory);
			inventoryRepo.insert(inventory);
		} else {
			System.out.println(inventory + " is over the stock quantity");
		}
	}

}


