package com.dmainali.vegitablefinder.controller;

import com.dmainali.vegitablefinder.entity.ResultWrapper;
import com.dmainali.vegitablefinder.exception.VegetableException;
import com.dmainali.vegitablefinder.service.ProductService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


@RestController
public class ProductController {

    private ProductService productService;
    ResultWrapper wrapper = new ResultWrapper();

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value= "/getList")
    public List<Pair<String,String>> findAll() {
        return productService.readProducts();
    }

    @GetMapping(value= "/getVegetables")
    public ResultWrapper findRandom() {
        try {
            List<Pair<String, String>> vlist = productService.readProducts();
            Random rand = new Random();
            int randomIndex = rand.nextInt(vlist.size());
            vlist.get(randomIndex);
            wrapper.setVegetable(vlist.get(randomIndex));
        }catch(VegetableException exception){
            wrapper.setVegetableException(exception);
        }
        return wrapper;
    }
}
