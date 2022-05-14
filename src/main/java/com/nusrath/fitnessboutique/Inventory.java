package com.nusrath.fitnessboutique;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//Data annotation generates all getters and setters
//Document @ marks Inventory class as being domain object that needs to be persisted on the database
@Data
@Document
public class Inventory {

    //@Id value is not null, it is stored in the database as-is
    @Id
    private String id;
    private String productName;
    private String price;
    @Indexed(unique = true)
    private String productNumber;
    private Category category;
    private Warehouse warehouse;

    public Inventory(String productName,
                     String price,
                     String productNumber,
                     Category category,
                     Warehouse warehouse) {

        this.productName = productName;
        this.price = price;
        this.productNumber = productNumber;
        this.category = category;
        this.warehouse = warehouse;
    }
}
