package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
//  CommandLineRunner helps us run a particular piece of code when the SpringBoot application starts (Interface)
    // Useful for presenting some sort of application to a client with dummy data.
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // When the application starts:
        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // Create Product
        Product phone = new Product();
        phone.setName("Smartphone");
        phone.setDescription("Latest model smartphone with great features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High performance Laptop with great gaming and coding features");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and Comfortable for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(199.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("Strong and Fast blender for all purpose");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(299.99);
        blender.setCategory(home);

        productRepository.saveAll(Arrays.asList(phone,laptop, jacket, blender));

        //placehold.co -> Gives simple, fast free image placeholder of various size (dummy image for test)
    }
}
