package com.productservice.productservice.dtos;

public class FakeStoreProductDto {
    // DTO -data transfer object --> it is user to transfer data b/w backend and the client
    // // Here as Product is a model and if there is any attribute that is added to the response, then we can't change the database (model) for any changes

    private Long id;
    private String title;
    private int price;
    private String category;// In Model category is a class, but in response through fakestore api we see it is a string
    private String description;
    private String image;
}
