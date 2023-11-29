package com.productservice.productservice.Services;

public interface ProductService {
    //Why Product Service is an Interface
    //1. Need object of Product Service in Product COntroller , so to avoid DI.
    //2. Currently we'll use fakestore APIs for imple of DB,apis. But later we can have more
    //than one implementation

      String getProductById(Long id);

     void getAllProducts();

     void deleteProductById();

     void createProduct();

     void updateProductById();
}
