package com.rosecorp.restaurantpicker.model;

import java.util.ArrayList;
import java.util.List;

public class Pickers {

    List<Picker> pickers;

    public Pickers() {
        this.pickers = new ArrayList<>();
    }

    public List<Picker> getPickers() {
        return pickers;
    }

    public void setPickers(List<Picker> pickers) {
        this.pickers = pickers;
    }
}
