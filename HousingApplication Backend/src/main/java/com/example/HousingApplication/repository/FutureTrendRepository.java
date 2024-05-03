package com.example.HousingApplication.repository;

import com.example.HousingApplication.model.FutureTrendData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutureTrendRepository extends JpaRepository<FutureTrendData, Long> {

}
