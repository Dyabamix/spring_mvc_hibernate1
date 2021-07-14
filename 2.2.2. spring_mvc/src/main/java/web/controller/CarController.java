package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printListCars(@RequestParam("count") int count,
                                @Autowired List<Car> cars,
                                ModelMap model){

            cars = cars.stream().limit(count).toList();


        model.addAttribute("cars", cars);
        return "Cars";
    }
}
