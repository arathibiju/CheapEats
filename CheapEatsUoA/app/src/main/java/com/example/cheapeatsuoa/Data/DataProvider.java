package com.example.cheapeatsuoa.Data;

import com.example.cheapeatsuoa.Model.Store;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {


    public static Map<Integer, String> generateCityStoreNames() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Mojo");
        stores.put(2, "Shaky Isles Coffee Co.");
        stores.put(3, "Needo Pasta");
        stores.put(4, "The Taco Joint");
        stores.put(5, "Munchy Mart");
        stores.put(6, "Shadows");
        stores.put(7, "Ha! Poke");
        stores.put(8, "Hollywood Bakery");
        stores.put(9, "Jewel of India");
        stores.put(10, "Hello Chinese");
        stores.put(11, "ChiChop");
        return stores;
    }

    public static Map<Integer, String> generateGraftonStoreNames() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Superfino");
        stores.put(2, "Poke House");
        stores.put(3, "Habitual Fix");
        stores.put(4, "Kebabs To Go");
        stores.put(5, "Subway");
        stores.put(6, "St Pierrs");
        stores.put(7, "Le Royal Bakery");
        stores.put(8, "Cafe Karadeniz");
        stores.put(9, "Columbus Coffee");
        stores.put(10, "Orceard Cafe");
        return stores;

    }

    public static Map<Integer, String> generateOffCampusStoreNames() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Eden Noodles");
        stores.put(2, "Sals");
        stores.put(3, "Pita Pit");
        stores.put(4, "Sumthin Dumplin");
        stores.put(5, "Obar Snack");
        stores.put(6, "Sensational Chicken");
        stores.put(7, "Pocha ");
        stores.put(8, "The Bowl");
        stores.put(9, "Nandos");
        stores.put(10,"Scarecrow");
        return stores;

    }
    public static ArrayList<Store> getCityStores() {
        ArrayList<Store> storeList = new ArrayList<Store>();
        Map<Integer, String> stores = generateCityStoreNames();
        for (Integer key : stores.keySet()) {
            int index = key;
            String name = stores.get(key);
            String image = "city_" + String.valueOf(key);
            String image_b = "city_" + String.valueOf(key) + "b";
            String image_c = "city_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name );
            storeList.add(s);
        }

        return storeList;
    }

    public static ArrayList<Store> getGraftonStores() {
        ArrayList<Store> storeList = new ArrayList<Store>();
        Map<Integer, String> stores = generateGraftonStoreNames();
        for (Integer key : stores.keySet()) {
            int index = key;
            String name = stores.get(key);
            String image = "grafton_" + String.valueOf(key);
            String image_b = "grafton_" + String.valueOf(key) + "b";
            String image_c = "grafton_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name );
            storeList.add(s);
        }

        return storeList;
    }
    public static ArrayList<Store> getOffCampusStores() {
        ArrayList<Store> storeList = new ArrayList<Store>();
        Map<Integer, String> stores = generateOffCampusStoreNames();
        for (Integer key : stores.keySet()) {
            int index = key;
            String name = stores.get(key);
            String image = "off_" + String.valueOf(key);
            String image_b = "off_" + String.valueOf(key) + "b";
            String image_c = "off_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name );
            storeList.add(s);
        }

        return storeList;
    }


}
