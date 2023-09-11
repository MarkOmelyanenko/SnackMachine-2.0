package com.example.controllers;

import com.example.domain.Product;
import com.example.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        Iterable<Product> products = productRepo.findAll();

        model.put("products", products);
        return "main";
    }

    @PostMapping("/")
    public String add(
            @RequestParam String name, @RequestParam double price,
            @RequestParam(required = false, defaultValue = "0") int quantity, @RequestParam LocalDate date,
            Map<String, Object> model
            ) {
        /*
        if (productRepo.findByName(name) == null) {
            Product product = new Product(name, price, quantity, date);
            productRepo.save(product);
        } else {
            model.put("message", "The product already exists!");
        }
         */

        Product product = new Product(name, price, quantity, date);
        productRepo.save(product);

        Iterable<Product> products = productRepo.findAll();

        model.put("products", products);

        return "main";
    }
}
