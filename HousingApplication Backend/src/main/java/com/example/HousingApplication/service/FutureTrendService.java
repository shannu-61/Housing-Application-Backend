package com.example.HousingApplication.service;

import com.example.HousingApplication.model.FutureTrendData;
import com.example.HousingApplication.repository.FutureTrendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutureTrendService {

    @Autowired
    private FutureTrendRepository futureTrendRepository;

    public List<FutureTrendData> getAllFutureTrends() {
        return futureTrendRepository.findAll();
    }


    public FutureTrendData predictFutureTrend(
            int year,
            double homeValueIncreasePercentage,
            double homeSalesDecreasePercentage,
            double mortgageRate
    ) {


        FutureTrendData futureTrendData = FutureTrendData.builder()
                .year(year)
                .homeValueIncreasePercentage(homeValueIncreasePercentage)
                .homeSalesDecreasePercentage(homeSalesDecreasePercentage)
                .mortgageRate(mortgageRate)
                .build();

        return futureTrendRepository.save(futureTrendData);
    }
}
