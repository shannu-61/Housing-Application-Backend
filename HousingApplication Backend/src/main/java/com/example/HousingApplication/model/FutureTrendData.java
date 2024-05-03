package com.example.HousingApplication.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FutureTrendData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private double homeValueIncreasePercentage;
    private double homeSalesDecreasePercentage;
    private double mortgageRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getHomeValueIncreasePercentage() {
        return homeValueIncreasePercentage;
    }

    public void setHomeValueIncreasePercentage(double homeValueIncreasePercentage) {
        this.homeValueIncreasePercentage = homeValueIncreasePercentage;
    }

    public double getHomeSalesDecreasePercentage() {
        return homeSalesDecreasePercentage;
    }

    public void setHomeSalesDecreasePercentage(double homeSalesDecreasePercentage) {
        this.homeSalesDecreasePercentage = homeSalesDecreasePercentage;
    }

    public double getMortgageRate() {
        return mortgageRate;
    }

    public void setMortgageRate(double mortgageRate) {
        this.mortgageRate = mortgageRate;
    }
}
