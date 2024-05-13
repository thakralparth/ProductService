package com.productservice.productservice;

import com.productservice.productservice.inheritancerelations.tableperclass.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner{
//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    ProductServiceApplication(/*@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository,StudentRepository studentRepository,UserRepository userRepository,*/
                              CategoryRepository categoryRepository,
                              ProductRepository productRepository,
                              PriceRepository priceRepository){
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository=userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

//    @Transactional
    @Override
    public void run(String... args) throws Exception {
////        Mentor mentor = new Mentor();
////        mentor.setName("Deepakk Kasera");
////        mentor.setEmail("deepak.kasera@scaler.com");
////        mentor.setAvgRating(4.8);
////
////        mentorRepository.save(mentor);
//
//
//
////        //tpc_mentor
////        Mentor mentor = new Mentor();
////        mentor.setName("Deepakk Kasera");
////        mentor.setEmail("deepak.kasera@scaler.com");
////        mentor.setAvgRating(4.8);
////
////        mentorRepository.save(mentor);
////
////
////        Student student = new Student();
////        student.setName("Parth");
////        student.setEmail("parth.thakral@gmail.com");
////        student.setPsp(86.50);
////
////        studentRepository.save(student);
////
////        User user = new User();
////        user.setName("Rohit");
////        user.setEmail("rohit@yahoo.com");
////
////        userRepository.save(user);
////
////        //Get all the users
////        List<User> users =userRepository.findAll();
////        for(User user1 : users){
////            System.out.println(user1.toString());
////        }
//
//
//
//
////        Category category = new Category();
////        category.setName("Apple Devices");
////
////        Category savedCategory = categoryRepository.save(category);
//
//
//
//
////        Optional<Category> optionalCategory =categoryRepository.findById(UUID.fromString("0efb11b4-765a-4a8a-900f-50ff2f1873d5"));
////
////        if(optionalCategory.isEmpty()){
////            throw new Exception("Category was null");
////        }
//
////        Category category = optionalCategory.get();
////
//
//
//
//
//
////        Product product  = new Product();
////        product.setTitle("iPhone 15 pro");
////        product.setDescription("best iphone ever");
//////        product.setCategory(optionalCategory.get());
////        product.setCategory(savedCategory);
////
////        Product savedProduct = productRepository.save(product);
//
//
//
//
//
//
//
//        //Find all products with category = Apple Devices
////        List<Product> products = category.getProducts();  // SQL query
////        for(Product product : products){
////            System.out.println(product.getTitle());  // failed to lazily initialize a collection of role: com.productservice.productservice.models.Category.products: could not initialize proxy - no Session
////        }
//
//
//
//
//
//
//        //M:M mapping, let's create an order class(mode)
//        // 1 order can have many products, 1 product can be part of many orders
//
//
//
//
//        // 1: 1 mapping. let's create a Price class
//        // 1 product will have 1 price, vice-versa
//
//        // Now we have marked price and category as mandatory
//        // SO to create a product, we first need price and category object
//
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//////
//        Price savedPrice = priceRepository.save(price);
////
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//////
//        Product product = new Product();
//        product.setTitle("iPhone 15 Pro");
//        product.setDescription("Best iphone ever");
//        product.setCategory(savedCategory);
//        product.setPrice(savedPrice);
////
//        Product savedProduct = productRepository.save(product);
//
//
//        //Now what if try to delete the above price
//        //product has dependency on this price., so we would get error
//        // so we'll have to delete teh product first
//
//
//        // But if we remove the dependency , unmark price and category as mandatory,
//        //then we can delete product while the price still exists
//        // but that price is of no significance
//
//        //CASCADING
//        // therefore we use CASCADE  as REMOVE on Price attr in Product class
//        // which will remove the price also if product is removed
//
////        productRepository.deleteById(UUID.fromString("a51d2af7-8a2f-4db3-b848-d07995340363"));
//        //priceRepository.deleteById(UUID.fromString("5469b12d-2665-4f02-acd2-cb5d63593528"));
//
//
//
//
//        // PERSIST CASCADING
//
////        Price price = new Price();
////        price.setCurrency("INR");
////        price.setValue(100000);
////
//////        Price savedPrice = priceRepository.save(price);
////
////        Category category = new Category();
////        category.setName("Apple Devices");
//////        Category savedCategory = categoryRepository.save(category);
////
////        Product product = new Product();
////        product.setTitle("iPhone 15 Pro");
////        product.setDescription("Best iphone ever");
////        product.setCategory(category);
////        product.setPrice(price);
////
////        Product savedProduct = productRepository.save(product);
//

//start here for adding 3 iphone products
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(150000);
//        price.setCurrency("INR");
//
//        Product product = new Product();
//        product.setPrice(price);
//        product.setTitle("iphone 15 Pro MAX");
//        product.setDescription("Best iphone ever");
//        product.setImage("IMG");
//        product.setCategory(savedCategory);
//        Product savedProduct = productRepository.save(product);
//
//
//        Price price1 = new Price();
//        price1.setValue(120000);
//        price1.setCurrency("INR");
//
//        Product product1 = new Product();
//        product1.setPrice(price1);
//        product1.setTitle("iphone 15 Pro");
//        product1.setDescription("Best iphone ever");
//        product1.setImage("IMG");
//        product1.setCategory(savedCategory);
//        Product savedProduct1 = productRepository.save(product1);
//
//
//        Price price2 = new Price();
//        price2.setValue(100000);
//        price2.setCurrency("INR");
//
//        Product product2 = new Product();
//        product2.setPrice(price2);
//        product2.setTitle("iphone 15");
//        product2.setDescription("Best iphone ever");
//        product2.setImage("IMG");
//        product2.setCategory(savedCategory);
//        Product savedProduct2 = productRepository.save(product2);


        // end here for adding 3 iphone products
//
////        Optional<Category> usedCategory = categoryRepository.findById(UUID.fromString("930619b4-3b2c-41c2-b613-951de67997a8"));
////
////        Category category = usedCategory.get();
////
////        List<Product> products = category.getProducts();
////
////        for(Product product : products){
////            System.out.println(product.getTitle());
////        }
//
//
//        // Th above 4 statements should be a single transaction , only then in LAZY loading we weill be able to get all products
//
//
//
//
//
//        //JPA Queries
////        List<Product> products = productRepository.findAll();
//
////        List<Product> products = productRepository.findAllByTitle("iphone 15 Pro MAX");
//
////        List<Product> products = productRepository.findAllByTitleAndDescription("iphone 15 Pro MAX", "Best iphone ever")
//
////        List<Product> products = productRepository.findAllByPrice_ValueGreaterThan(100000);
//
////        List<Product> products = productRepository.findAllByPrice_ValueBetween(90000,120000);
//    }

    }
}
