package com.dmainali.vegitablefinder.entity;

import com.dmainali.vegitablefinder.exception.VegetableException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Getter
@Setter
public class ResultWrapper {

    public Pair<String,String> vegetable;
    public VegetableException vegetableException;

}
