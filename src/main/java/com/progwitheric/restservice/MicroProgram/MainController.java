package com.progwitheric.restservice.MicroProgram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    RestTemplate restTemplate = new RestTemplate();

    public static final String url = "http://localhost:8080/voitures/";

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
    public String getCars(Model model) {

        Cars[] cars = restTemplate.getForObject(url,Cars[].class);
        model.addAttribute("cars", cars);

        return "carsList";
    }

    @RequestMapping(value = { "/addCars" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        Cars cars = new Cars();
        model.addAttribute("cars", cars);

        return "addCars";
    }

    @RequestMapping(value = { "/addCars" }, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("cars") Cars cars) {

        String name = cars.getName();
        String modele = cars.getModel();

        if (name != null && modele!= null //
                && name.length() > 0 && modele.length() > 0) {
            restTemplate.postForLocation(url, cars, Cars.class);

            return "redirect:/carsList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCars";
    }
    @GetMapping(value = {"/editCar/{id}"})
    public String getModifyCar(Model model, @PathVariable("id") int id){

        model.addAttribute("car", restTemplate.getForObject(url + id, Cars.class));
        return "editCar";
    }


    @GetMapping(value = { "/modifyCars" })
    public String modifyCar(@ModelAttribute("cars") Cars car) {

        restTemplate.put(url, car, Cars.class);

        return "redirect:/carsList";
    }

    @GetMapping(value = { "/deleteCar/{id}"})
    public String deleteCar(@PathVariable("id") int id){

        restTemplate.delete(url + id);

        return "redirect:/carsList";
    }

}
