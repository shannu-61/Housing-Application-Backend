package com.example.HousingApplication.controller;

import com.example.HousingApplication.exception.HomeNotFoundException;
import com.example.HousingApplication.model.Home;
import com.example.HousingApplication.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeService homeService;

    @GetMapping("/api/home/fetch")
    public String allHomes(Model model) {
        LOGGER.info("inside allHomes of HomeController");

        // Retrieve the list of homes from the service
        List<Home> homes = homeService.getAllHomes();

        // Add the list of homes to the model
        model.addAttribute("homes", homes);

        // Return the name of the Thymeleaf view (assuming the Thymeleaf template is named "allHomes")
        return "allHomes";
    }

    @GetMapping("/api/home/by-city")
    public String getHomesByCity(@RequestParam String city, Model model) {
        LOGGER.info("Retrieving homes in {}", city);

        List<Home> homes = homeService.getHomesByCity(city);

        model.addAttribute("homes", homes);
        model.addAttribute("message", "Homes in " + city); // Update message to display filtered city

        return "allHomes";
    }

    @GetMapping("/api/home/fetch/{id}")
    public ModelAndView fetchHomeById(@PathVariable("id") Long houseId) throws HomeNotFoundException {
        LOGGER.info("inside fetchHomeById of HomeController");

        Optional<Home> home = homeService.fetchHomeById(houseId);
        if (!home.isPresent()) {
            throw new HomeNotFoundException("house Id not found");
        } else {
            ModelAndView modelAndView = new ModelAndView("homeDetails"); // assuming "homeDetails" is your view name

            modelAndView.addObject("home", home.get());
            modelAndView.addObject("message", "Details for home with ID " + houseId);

            return modelAndView;
        }
    }

    @GetMapping("/api/home/budgethomes")
    public String getHomesUnderBudget(@RequestParam(name = "price") double price, Model model) {
        LOGGER.info("Retrieving homes under budget: {}", price);

        List<Home> homes = homeService.homesUnderBudget(price);

        model.addAttribute("homes", homes);
        model.addAttribute("message", "Homes under budget: " + price);

        return "allHomes";
    }


}




