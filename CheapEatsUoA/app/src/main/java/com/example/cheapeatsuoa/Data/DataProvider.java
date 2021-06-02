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
        stores.put(10, "ChiChop");
        return stores;
    }
    public static Map<Integer, String> generateCityStoreLocations() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "HSB Courtyard, Auckland University, 10 Symonds Street");// mojo
        stores.put(2, "Kate Edger Information Commons, 11 Symonds St");// shaky isles
        stores.put(3, "Kate Edger Information Commons, 11 Symonds St"); // needo
        stores.put(4, "Kate Edger Information Commons, 11 Symonds St");// taco
        stores.put(5, "Kate Edger Information Commons, 11 Symonds St");//munchy
        stores.put(6, "8 Alfred St (next to AUSA)"); //shadows
        stores.put(7, "Arts Quad: 10 Symonds St"); //ha poke
        stores.put(8, "Student Quad, 34 Princes St");// hollywood
        stores.put(9, "Student Quad, 34 Princes St");// jewel of india
        stores.put(10, "Student Quad, 34 Princes St");// chi chop
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
    public static Map<Integer, String> generateGraftonStoreLocations() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Grafton Campus: 85 Park Rd");
        stores.put(2, "110 Grafton Rd Grafton");
        stores.put(3, "Ground Floor Auckland Hospital, retail strip 2 Park Rd, Grafton, Auckland");
        stores.put(4, "37 Park Road, Grafton Street, Grafton, Auckland 1023");
        stores.put(5, "61 Park Road, Grafton, Auckland 1023");
        stores.put(6, "Ground level 2 Park Road, 1023");
        stores.put(7, "21 Park Road, Grafton, Auckland 1023");
        stores.put(8, "3 Park Rd, Auckland Central, NZ");
        stores.put(9, "Auckland Hospital, 2 Park Road, Grafton, Auckland 1023");
        stores.put(10, "31 Park Road, Grafton, Auckland");
        return stores;

    }

    public static Map<Integer, String> generateOffCampusStoreNames() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Eden Noodles");
        stores.put(2, "Sals");
        stores.put(3, "Sumthin Dumplin");
        stores.put(4, "The Shelf");
        stores.put(5, "Sensational Chicken");
        stores.put(6, "Pocha");
        stores.put(7, "Nandos");
        stores.put(8, "Pita Pit");
        stores.put(9,"Starbucks");
        stores.put(10,"Scarecrow");
        return stores;
    }
    public static Map<Integer, String> generateOffCampusStoreLocations() {
        Map<Integer, String> stores =
                new LinkedHashMap<>();
        stores.put(1, "Shop3/18-26 Wellesley Street E, Auckland, Auckland 1008, New Zealand");
        stores.put(2, "265 Queen St, Auckland, New Zealand");
        stores.put(3, "18-26 Wellesley Street E, Auckland, Auckland 1010, New Zealand");
        stores.put(4, "50 High Street, Auckland CBD");
        stores.put(5, "11A Mount Sreet, CBD");
        stores.put(6, "2a / 48 Courthouse Lane, Chancery SQ, Auckland CBD");
        stores.put(7, "360 Queen Street, Auckland AUCK 1148");
        stores.put(8, "43 Symonds St, Grafton, Auckland 1010");
        stores.put(9,"37 Symonds Street Unit G01, Grafton, Auckland 1010, ");
        stores.put(10,"33 Victoria St E, Auckland, 1010, New Zealand");
        return stores;

    }
    public static ArrayList<Store> getCityStores() {
        ArrayList<Store> storeList = new ArrayList<Store>();
        Map<Integer, String> storeNames = generateCityStoreNames();
        Map<Integer, String> storeLocations = generateCityStoreLocations();
        for (Integer key : storeNames.keySet()) {
            int index = key;
            String name = storeNames.get(key);
            String location = storeLocations.get(key);
            String image = "city_" + String.valueOf(key);
            String image_b = "city_" + String.valueOf(key) + "b";
            String image_c = "city_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name, location );
            storeList.add(s);
        }

        return storeList;
    }

    public static ArrayList<Store> getGraftonStores() {
        ArrayList<Store> storeList = new ArrayList<>();
        Map<Integer, String> stores = generateGraftonStoreNames();
        Map<Integer, String> storeLocations = generateCityStoreLocations();

        for (Integer key : stores.keySet()) {
            int index = key;
            String name = stores.get(key);
            String location = storeLocations.get(key);
            String image = "grafton_" + String.valueOf(key);
            String image_b = "grafton_" + String.valueOf(key) + "b";
            String image_c = "grafton_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name, location);
            storeList.add(s);
        }

        return storeList;
    }
    public static ArrayList<Store> getOffCampusStores() {
        ArrayList<Store> storeList = new ArrayList<Store>();
        Map<Integer, String> stores = generateOffCampusStoreNames();
        Map<Integer, String> storeLocations = generateOffCampusStoreLocations();
        for (Integer key : stores.keySet()) {
            int index = key;
            String name = stores.get(key);
            String location = storeLocations.get(key);
            String image = "off_" + String.valueOf(key);
            String image_b = "off_" + String.valueOf(key) + "b";
            String image_c = "off_" + String.valueOf(key) + "c";

            Store s = new Store ( index, image, image_b, image_c, name, location );
            storeList.add(s);
        }

        return storeList;
    }


}
