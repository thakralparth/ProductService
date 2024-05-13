package com.productservice.productservice.repositories;

import com.productservice.productservice.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();  // Get all the products from Product table

    List<Product> findAllByTitle(String Title);

    List<Product> findAllByTitleContainingIgnoreCase(String Title, Pageable pageable);// for whatever db call we need paging we send request as this

    List<Product> findAllByTitleAndDescription(String title, String desc);

    List<Product> findAllByPrice_ValueGreaterThan(Integer x);
    @Query(value = "Select * from product",nativeQuery = true)
    List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);

    //JPA always writes the generalized queries which might not be the efficient so if we want to wri
    //the queries ourself we can overwrite using query notation
}
