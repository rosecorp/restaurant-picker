package com.rosecorp.restaurantpicker.service;

import com.rosecorp.restaurantpicker.model.MostPopular;
import com.rosecorp.restaurantpicker.model.Picker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class RestaurantPickerService {

    Map<String, Picker> store = new ConcurrentHashMap<>();

    public void store(String key, Picker value) {
        store.put(key, value);
    }

    public Picker get(String key) {
        return store.get(key);
    }

    public List<Picker> getAll() {
        return new ArrayList<>(store.values());
    }

    public List<MostPopular> popular() {
        ArrayList<Picker> pickers = new ArrayList<>(store.values());
        Map<String, Long> popularMap = pickers.stream().collect(Collectors.groupingBy(Picker::getRestaurantName, Collectors.counting()));
        List<MostPopular> popular = new ArrayList<>();
        popularMap.forEach((k,v)-> popular.add(new MostPopular(k, v)));

        popular.sort(Comparator.comparing(MostPopular::getVote).reversed());

        return popular;
    }

}
