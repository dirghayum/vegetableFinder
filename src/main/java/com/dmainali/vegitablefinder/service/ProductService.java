package com.dmainali.vegitablefinder.service;

import com.dmainali.vegitablefinder.dataprocessor.ProductReader;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    public List<Pair<String,String>> readProducts(){
        ProductReader productReader = new ProductReader();
        return productReader.readProducts();
    }

}
