package com.rosecorp.restaurantpicker.service;

import com.rosecorp.restaurantpicker.model.Picker;
import com.rosecorp.restaurantpicker.model.Pickers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public Pickers getAll() {
        Pickers pickers = new Pickers();
        pickers.setPickers(new ArrayList<>(store.values()));
        return pickers;
    }

    public Map<String, Long>  popular() {
        ArrayList<Picker> pickers = new ArrayList<>(store.values());
        Map<String, Long> collect = pickers.stream().collect(Collectors.groupingBy(Picker::getName, Collectors.counting()));

        return collect;
    }

}
