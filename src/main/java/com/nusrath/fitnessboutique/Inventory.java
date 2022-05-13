package com.nusrath.fitnessboutique;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Inventory {

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
