package com.dmainali.vegitablefinder.dataprocessor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


@Slf4j
public class ProductReader {

    public static final String FILE_NAME= "src/main/resources/data/vegetables.txt";

    public static Set<Pair<String, String>> vegetableList = new LinkedHashSet<>();


    public Set<Pair<String, String>> readProducts()  {
        Pair<String,String> pair;
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while(line != null){
                pair = cleanData(line);
                vegetableList.add(pair);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(fr!= null){
                    fr.close();
                }
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("Inserted "+vegetableList.size()+" items in the list");
        return vegetableList;
    }

    public Pair cleanData(String line) {
        String[] parts = line.split("\\s*\\(\\s*");
        String veggieName = parts[0];
        String sciName = parts[1].replaceAll("\\)$", "");
        return new ImmutablePair<>(veggieName,sciName);
    }
}
