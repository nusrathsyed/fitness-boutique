package com.nusrath.fitnessboutique;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Warehouse {

    private String name;
    private String location;

    public Warehouse() {

        
    }
}
