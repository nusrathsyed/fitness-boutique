package com.nusrath.fitnessboutique;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface WarehouseRepository extends MongoRepository<Warehouse, String> {

  List<Warehouse> findWarehouseByName(String name);




}
