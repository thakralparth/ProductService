package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    //Why Product Service is an Interface
    //1. Need object of Product Service in Product COntroller , so to avoid DI.
    //2. Currently we'll use fakestore APIs for imple of DB,apis. But later we can have more
    //than one implementation

      GenericProductDto getProductById(Long id);

     List<GenericProductDto> getAllProducts();

     void deleteProductById();

     GenericProductDto createProduct(GenericProductDto genericProductDto);

     void updateProductById();
}
