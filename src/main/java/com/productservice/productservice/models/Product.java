package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    private Long id;
    private String title;
    private String description;
    private int price;
    private String image;

    //Category isn't a primitive attribute, its a relation
    @ManyToOne
    private Category category;

}

/*
Cardinality b/w in product ---- category


 */
