package com.testGrapql.demo.controller;

import com.testGrapql.demo.dto.ProductInput;
import com.testGrapql.demo.entity.Product;
import com.testGrapql.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @QueryMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return service.getProductsByCategory(category);
    }

    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return service.updateStock(id, stock);

    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return service.receiveNewShipment(id, quantity);

    }

    @MutationMapping
    public Product insertNew(@Argument("product") ProductInput productInput) {
        Product product = new Product();
        product.setName(productInput.getName());
        product.setCategory(productInput.getCategory());
        product.setPrice(productInput.getPrice());
        product.setStock(productInput.getStock());

        return service.insertNewProdcut(product);
    }

}
