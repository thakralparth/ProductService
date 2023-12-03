package com.productservice.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private int price;
    private String category;// In Model category is a class, but in response through fakestore api we see it is a string
    private String description;
    private String image;
}
