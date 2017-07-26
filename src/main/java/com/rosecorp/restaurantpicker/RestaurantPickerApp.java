package com.rosecorp.restaurantpicker;

import com.rosecorp.restaurantpicker.model.Picker;
import com.rosecorp.restaurantpicker.model.Pickers;
import com.rosecorp.restaurantpicker.service.RestaurantPickerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
@SpringBootApplication
public class RestaurantPickerApp {

    @Resource
    private RestaurantPickerService restaurantPickerService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Pick your restaurant! boom!!!! Go here to get instructions https://github.com/rosecorp/restaurant-picker";
    }

    @RequestMapping("/restaurant/{name}/when/{then}/who/{me}")
    @ResponseBody
    public void pickYourRestaurant(@PathVariable String name, @PathVariable String then, @PathVariable String me) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {

            Date thenDate = formatter.parse(then);
            restaurantPickerService.store(me, new Picker(name, thenDate, me));

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/restaurant/votes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Pickers view() {
        return restaurantPickerService.getAll();
    }

    @RequestMapping(value = "/restaurant/popular", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Long> mostPopular() {
        return restaurantPickerService.popular();
    }


    public static void main(String[] args) {
        SpringApplication.run(RestaurantPickerApp.class, args);
    }

}
