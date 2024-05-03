package com.example.HousingApplication.controller;

import com.example.HousingApplication.model.FutureTrendData;
import com.example.HousingApplication.service.FutureTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class FutureTrendController {

    @Autowired
    private FutureTrendService futureTrendService;

    @GetMapping("/api/future-trends/predict")
    public String predictFutureTrend(
            @RequestParam int year,
            @RequestParam double homeValueIncreasePercentage,
            @RequestParam double homeSalesDecreasePercentage,
            @RequestParam double mortgageRate,
            Model model
    ) {
        FutureTrendData predictionResult = futureTrendService.predictFutureTrend(
                year,
                homeValueIncreasePercentage,
                homeSalesDecreasePercentage,
                mortgageRate
        );

        model.addAttribute("predictionResult", predictionResult);

        // Return the Thymeleaf template name
        return "future-trends";
    }

    @GetMapping("/api/future-trends/all")
    public String getAllFutureTrends(Model model) {
        List<FutureTrendData> allFutureTrends = futureTrendService.getAllFutureTrends();

        model.addAttribute("allFutureTrends", allFutureTrends);

        // Return the Thymeleaf template name
        return "future-trends";
    }

}
