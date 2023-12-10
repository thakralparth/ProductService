package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    //Why Product Service is an Interface
    //1. Need object of Product Service in Product COntroller , so to avoid DI.
    //2. Currently we'll use fakestore APIs for imple of DB,apis. But later we can have more
    //than one implementation

      GenericProductDto getProductById(Long id) throws ProductNotFoundException;

     List<GenericProductDto> getAllProducts();

     GenericProductDto deleteProductById(Long id);

     GenericProductDto createProduct(GenericProductDto genericProductDto);

     GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);
}
