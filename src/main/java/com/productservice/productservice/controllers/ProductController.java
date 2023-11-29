package com.productservice.productservice.controllers;

import com.productservice.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController //1. we need object of this class at runtime (PRE-INITIALIZED)
//2. rest -- BECAUSE IT CONTAINS REST APIs
@RequestMapping("/products")  // all rest apis hosted at root mapping
public class ProductController {
    //CRUD

    private ProductService productService;
    //COnstructor Injection
    //To create an object of Controller we need object of Service
    // we never create object by ourself in Spring Application (therefore @Service)
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){ //Spring can get confuse here which class to put hence Qualifier
        this.productService = productService;
    }

    //localhost:8080/products/123

    //@Autowired
//    @GetMapping("/products/{id}")
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){ //this id we will have to pick from path of URL
        //Call the FakeStoreProductService getProductById() method.

        //return "Productssss fetched with id: " +id;

        return productService.getProductById(id);
    }
//    @GetMapping("/products")
    @GetMapping
    public void getAllProducts(){

    }
//    @DeleteMapping("/products/{id}")
    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }

    public void createProduct(){

    }

    public void updateProductById(){

    }


    /*
    * 3 ways of Dependency Injection
    *
    * 1. COnstructor Injection
    * 2. Field Injection
    * 3. Setter Injection
    *
    *
    *
    * */
}
