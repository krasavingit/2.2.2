package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class CarsController {
    @RequestMapping(value = "/cars", method = GET)
    public String printCars(@RequestParam(value = "locale") String locale, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "toyota", "corona"));
        cars.add(new Car(2, "toyota", "corolla"));
        cars.add(new Car(3, "toyota", "crown"));
        cars.add(new Car(4, "toyota", "corse"));
        if(locale.equals("ru")) {
            model.addAttribute("title", "Машины");
        }
        if(locale.equals("en")) {
            model.addAttribute("title", "Cars");
        }
        model.addAttribute("car", cars);
        return "indexCar";
    }
}