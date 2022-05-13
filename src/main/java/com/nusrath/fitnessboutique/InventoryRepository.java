package com.nusrath.fitnessboutique;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    Optional<Inventory> findInventoryByProductName(String productName);



}
