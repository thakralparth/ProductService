package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    private Long id;
    private String title;
    private String description;
//    private int price;  now we created a price model for 1:1 mapping
    private String image;

    //Category isn't a primitive attribute, its a relation
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(optional = false)
    @JoinColumn(nullable = false)
    private Price price;

}

/*
Cardinality b/w in product ---- category


 */
