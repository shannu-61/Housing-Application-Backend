package com.example.HousingApplication.service;

import com.example.HousingApplication.model.HistoricalData;
import com.example.HousingApplication.repository.HistoricalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class HistoricalDataService {

    @Autowired
    private HistoricalDataRepository historicalDataRepository;

    public List<HistoricalData> getHistoricalDataDescendingOrder() {
        int currentYear = Year.now().getValue();
        Sort sort = Sort.by(Sort.Direction.DESC, "year");
        return historicalDataRepository.findByYearLessThan(currentYear, sort);
    }

    // Additional service methods as needed
}
