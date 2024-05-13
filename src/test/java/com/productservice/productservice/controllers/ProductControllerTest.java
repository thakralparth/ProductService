package com.productservice.productservice.controllers;

import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Inject
    ProductController productController;

//    ProductControllerTest(ProductController productController){
//        this.productController = productController;
//    }
    @MockBean
    ProductService productService;

    @Captor
    ArgumentCaptor<Long> argumentCaptor;

//    @Test
//    @DisplayName("Testing 1 + 1 is 2")
//    void testOnePlusOneIsTwoOrNot(){
////        assert(11 == 1+1);
////        assertEquals(11,1+1,"1 + 1 should be 2");
//        //Checks the expected value(2) vs the output of the expression
//        assertTrue(1==1);
//        //If assert is true , test case succeeds , else fails
    }

//@Test
//    void testGetProductByIdNegativeTC() throws ProductNotFoundException {
////        assertThrows(ProductNotFoundException.class,() -> productController.getProductById(1000L));
//        assertNull(productController.getProductById(1000L));
//    }

//    @Test
//    void testGetProductByIdMocking() throws ProductNotFoundException {
//        GenericProductDto genericProductDto = new GenericProductDto();
//        when(productService.getProductById(any(Long.class))).thenReturn(genericProductDto);
//
//        GenericProductDto genericProductDto1 = productController.getProductById(100L);
//        assertEquals(genericProductDto, genericProductDto1);
//    }

//    @Test
//    void testGetProductByIdCustomLogic() throws ProductNotFoundException {
//        GenericProductDto genericProductDto = new GenericProductDto();
//        when(productService.getProductById(any(Long.class))).thenReturn(genericProductDto);
//
//        GenericProductDto genericProductDto1 = productController.getProductById(100L);
//        assertEquals(genericProductDto, genericProductDto1);
//    }

//    @Test
//    @DisplayName("testProductControllerCallsProductServiceWithSameProductIdAsInput")
//    void testIfSameInput() throws ProductNotFoundException {
//        //This is the test case to check if product controller is passing the same productId to the
//        //productService as the Input
//        Long id = 100L;
//
//        when(productService.getProductById(id)).thenReturn(new GenericProductDto());
//
//        GenericProductDto genericProductDto = productController.getProductById(id);
//
//        verify(productService).getProductById(argumentCaptor.capture());
//
//        assertEquals(id, argumentCaptor.getValue());
//
//    }




//}
