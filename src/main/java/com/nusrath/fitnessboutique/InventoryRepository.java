package com.nusrath.fitnessboutique;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findInventoryById(String id);

    List<Inventory> findAll();

    void deleteById(String id);

}
