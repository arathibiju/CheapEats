package com.example.cheapeatsuoa.Data;

import java.util.LinkedHashMap;
import java.util.Map;

public class DataProvider {


    public static Map<Integer, String> generateCityStoreNames() {
        Map<Integer, String> words =
                new LinkedHashMap<>();
        words.put(1, "Mojo");
        words.put(2, "Shaky Isles Coffee Co.");
        words.put(3, "Needo Pasta");
        words.put(4, "The Taco Joint");
        words.put(5, "Munchy Mart");
        words.put(6, "Shadows");
        words.put(7, "Ha! Poke");
        words.put(8, "Hollywood Bakery");
        words.put(9, "Jewel of India");
        words.put(10, "Hello Chinese");
        words.put(11, "ChiChop");
        return words;

    }
    public static Map<Integer, String> generateGraftonStoreNames() {
        Map<Integer, String> words =
                new LinkedHashMap<>();
        words.put(1, "Superfino");
        words.put(2, "Domain Deli");
        words.put(3, "Anastasis Coffee Roasters");
        words.put(4, "Kebabs To Go");
        words.put(5, "Subway");
        words.put(6, "St Pierrs");
        words.put(7, "Le Royal Bakery");
        words.put(8, "Cafe Karadeniz");
        words.put(9, "Grafton Convenience Store");
        words.put(10, "Orceard Cafe");
        return words;

    }

    public static Map<Integer, String> generateOffCampusStoreNames() {
        Map<Integer, String> words =
                new LinkedHashMap<>();
        words.put(1, "Eden Noodles");
        words.put(2, "Sals");
        words.put(3, "Pita Pit");
        words.put(4, "Sumthin Dumplin");
        words.put(5, "Obar Snack");
        words.put(6, "Sensational Chicken");
        words.put(7, "Pocha ");
        words.put(8, "The Bowl");
        words.put(9, "Nandos");
        words.put(10,"Scarecrow");
        return words;

    }
}
