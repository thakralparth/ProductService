package com.productservice.productservice.controllers;

import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //1. we need object of this class at runtime (PRE-INITIALIZED)
//2. rest -- BECAUSE IT CONTAINS REST APIs
@RequestMapping("/products")  // all rest apis hosted at root mapping
public class ProductController {
    //CRUD

    private ProductService productService;
    //COnstructor Injection
    //To create an object of Controller we need object of Service
    // we never create object by ourself in Spring Application (therefore @Service)
//    @Qualifier("fakeStoreProductService")
    ProductController( ProductService productService){ //Spring can get confuse here which class to put hence Qualifier
        this.productService = productService;
    }

    //localhost:8080/products/123

    //@Autowired
//    @GetMapping("/products/{id}")
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @PathVariable("id") Long id) throws ProductNotFoundException { //this id we will have to pick from path of URL
        //Call the FakeStoreProductService getProductById() method.

        //return "Productssss fetched with id: " +id;


        //Custom Logic for Testing
        GenericProductDto genericProductDto = productService.getProductById(authToken,id);
        return genericProductDto;
//
//        GenericProductDto genericProductDto1 = new GenericProductDto();
//        return genericProductDto1;


//        return productService.getProductById(id);
    }
//    @GetMapping("/products")
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
//    @DeleteMapping("/products/{id}")
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id,@RequestBody GenericProductDto genericProductDto){
        return productService.updateProductById(id,genericProductDto);
    }


    // if any method of controller returns ProductNotFoundException this method should trigger
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
////        System.out.println("Got Product not found exception");
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
////        System.out.println("Got Product not found exception");
//
////        return exceptionDto;
//
//        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }





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
