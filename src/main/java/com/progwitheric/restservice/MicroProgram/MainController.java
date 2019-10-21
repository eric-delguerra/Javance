package com.progwitheric.restservice.MicroProgram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private static List<Cars> cars = new ArrayList<Cars>();

    static {
        cars.add(new Cars("Audi", "A4"));
        cars.add(new Cars("Renaud", "R5"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/carsList" }, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("cars", cars);

        return "carsList";
    }

    @RequestMapping(value = { "/addCars" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        CarsForm carsForm= new CarsForm();
        model.addAttribute("carsForm", carsForm);

        return "addCars";
    }

    @RequestMapping(value = { "/addCars" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("carsForm") CarsForm carsForm) {

        String name = carsForm.getName();
        String modele = carsForm.getModel();

        if (name != null && modele!= null //
                && name.length() > 0 && modele.length() > 0) {
            Cars newCars = new Cars(name, modele);
            cars.add(newCars);

            return "redirect:/carsList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCars";
    }

}
