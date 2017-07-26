package com.rosecorp.restaurantpicker.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Picker {

    String name, me;
    Date then;

    public Picker(String name, Date then, String me) {
        this.name = name;
        this.then = then;
        this.me = me;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThen() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(then).toString();
    }

    public void setThen(Date then) {
        this.then = then;
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
    }
}
