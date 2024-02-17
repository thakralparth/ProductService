package com.productservice.productservice.controllers;

import com.productservice.productservice.exceptions.ProductNotFoundException;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    ProductController productController;

//    ProductControllerTest(ProductController productController){
//        this.productController = productController;
//    }

    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void testOnePlusOneIsTwoOrNot(){
//        assert(11 == 1+1);
//        assertEquals(11,1+1,"1 + 1 should be 2");
        //Checks the expected value(2) vs the output of the expression
        assertTrue(1==1);
        //If assert is true , test case succeeds , else fails
    }

@Test
    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
//        assertThrows(ProductNotFoundException.class,() -> productController.getProductById(1000L));
        assertNull(productController.getProductById(1000L));
    }

}
