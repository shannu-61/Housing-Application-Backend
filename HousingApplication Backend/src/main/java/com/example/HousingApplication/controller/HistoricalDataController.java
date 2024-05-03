package com.example.HousingApplication.controller;

import com.example.HousingApplication.model.HistoricalData;
import com.example.HousingApplication.service.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HistoricalDataController {

    @Autowired
    private HistoricalDataService historicalDataService;

    @GetMapping("/historic-trends")
    public String getHistoricalDataDescendingOrder(Model model) {
        List<HistoricalData> historicalDataList = historicalDataService.getHistoricalDataDescendingOrder();
        model.addAttribute("historicalDataList", historicalDataList);
        return "historic-details";
    }
}
