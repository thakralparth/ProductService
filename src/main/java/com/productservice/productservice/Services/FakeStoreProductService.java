package com.productservice.productservice.Services;

import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    @Override
    public String getProductById(Long id) {
        //Integrate the fakestore api
        //RestTemplate --can help you to make the call to external systems
//        return null;
        return "Parth || Product fetched with id: " +id;
    }

    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
