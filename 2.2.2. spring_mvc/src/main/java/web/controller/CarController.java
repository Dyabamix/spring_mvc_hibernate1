package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printListCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("model1", 112233, "a001bc"));
        cars.add(new Car("model2", 223344, "a002bc"));
        cars.add(new Car("model3", 334455, "a003bc"));
        cars.add(new Car("model4", 445566, "a004bc"));
        cars.add(new Car("model5", 556677, "a005bc"));

        if (count != null) {
            cars = cars.stream().limit(count).collect(Collectors.toList());
        }


        model.addAttribute("cars", cars);
        return "Cars";
    }
}
