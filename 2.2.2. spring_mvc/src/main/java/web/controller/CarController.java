package web.controller;

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
    public String printListCars(@RequestParam("count") int count, ModelMap model){
        List<Car> listCars = new ArrayList<>();

        listCars.add(new Car("model1", 112233, "a001bc"));
        listCars.add(new Car("model2", 223344, "a002bc"));
        listCars.add(new Car("model3", 334455, "a003bc"));
        listCars.add(new Car("model4", 445566, "a004bc"));
        listCars.add(new Car("model5", 556677, "a005bc"));

        listCars = listCars.stream().limit(count).toList();

        model.addAttribute("cars", listCars);
        return "Cars";
    }
}
