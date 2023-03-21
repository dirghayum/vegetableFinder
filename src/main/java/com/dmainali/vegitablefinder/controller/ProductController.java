package com.dmainali.vegitablefinder.controller;

import com.dmainali.vegitablefinder.service.ProductService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value= "/getList")
    public Set<Pair<String,String>> findAll() {
        return productService.readProducts();
    }
}
