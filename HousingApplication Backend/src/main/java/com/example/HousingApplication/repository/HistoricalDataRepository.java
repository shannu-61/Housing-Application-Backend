package com.example.HousingApplication.repository;

import com.example.HousingApplication.model.HistoricalData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricalDataRepository extends JpaRepository<HistoricalData, Long> {

    // Custom query method to fetch historical data with a year less than the current year
    List<HistoricalData> findByYearLessThan(int currentYear, Sort sort);
}
