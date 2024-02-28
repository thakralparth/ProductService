package com.productservice.productservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.Services.ProductService;
import com.productservice.productservice.dtos.GenericProductDto;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

//It won't initialize the unnecessary dependencies
@WebMvcTest(ProductController.class)
public class ProductControllerWebMvcTest {
    @MockBean
    ProductService productService;
    @Inject
    private MockMvc mockMvc;
    @Inject
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProductsReturnsEmptyList() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());


        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }


    @Test
    void testGetAllProductsReturnsValidList() throws Exception {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProducts())
                .thenReturn(genericProductDtos);


        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void createProductShouldCreateAVAlidNewProduct() throws Exception {
        GenericProductDto productToCreate = new GenericProductDto();
        productToCreate.setTitle("MacBook");
        productToCreate.setPrice(200000);
        productToCreate.setDescription("Fastest MAc Ever");
        productToCreate.setCategory("Laptop");

        GenericProductDto outputGenericProductDto = new GenericProductDto();
        outputGenericProductDto.setCategory(productToCreate.getCategory());
        outputGenericProductDto.setPrice(productToCreate.getPrice());
        outputGenericProductDto.setTitle(productToCreate.getTitle());
        outputGenericProductDto.setDescription(productToCreate.getDescription());
        outputGenericProductDto.setId(1000L);

        when(productService.createProduct(any()))
                .thenReturn(outputGenericProductDto);


        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate))
                )
                .andExpect(
                        content().string(objectMapper.writeValueAsString(outputGenericProductDto))
                )
                .andExpect(status().is(200))
                //added two dependencies for below lines to work - hamcrest and assertj
                .andExpect(jsonPath("$.title", is("MacBook")))
                .andExpect(jsonPath("$.price",is(200000)));


    }
}


/*
{$
    student: {
        id:"1",
        "name":"Deepak",
        psp:
}

 */