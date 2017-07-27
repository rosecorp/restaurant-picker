package com.rosecorp.restaurantpicker.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Picker {

    @Size(min = 4, max = 35)
    private String restaurantName;

    @Size(min = 1, max = 35)
    private String personName;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateToGo;

    public Picker() {
    }

    public Picker(String restaurantName, String personName, Date dateToGo) {
        this.restaurantName = restaurantName;
        this.personName = personName;
        this.dateToGo = dateToGo;
    }

    public Date getDateToGo() {
        return dateToGo;
    }

    public void setDateToGo(Date dateToGo) {
        this.dateToGo = dateToGo;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
