package com.rosecorp.restaurantpicker;

import com.rosecorp.restaurantpicker.model.MostPopular;
import com.rosecorp.restaurantpicker.model.Picker;
import com.rosecorp.restaurantpicker.service.RestaurantPickerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RestaurantPickerController {

    @Value("${welcome.message:test}")

    @Resource
    private RestaurantPickerService restaurantPickerService;

    @RequestMapping(value = "/popular", method = RequestMethod.GET)
    public String popular(Model model) {

        List<MostPopular> popularList = restaurantPickerService.popular();

        model.addAttribute("popularList", popularList);

        return "popular";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Picker picker) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String picker(@Valid Picker picker, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("restaurantName", picker.getRestaurantName());
        model.addAttribute("personName", picker.getPersonName());
        model.addAttribute("dateToGo", picker.getDateToGo());

        restaurantPickerService.store(picker.getPersonName(), picker);
        List<MostPopular> popularList = restaurantPickerService.popular();

        model.addAttribute("popularList", popularList);

        return "popular";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String all(Model model) {
        List<Picker> all = restaurantPickerService.getAll();
        model.addAttribute("all", all);

        return "all";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
    }



}
