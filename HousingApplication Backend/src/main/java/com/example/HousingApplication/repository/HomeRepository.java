package com.example.HousingApplication.repository;

import com.example.HousingApplication.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{

	List<Home> findByPriceLessThan(double price);
	
	Optional<Home>findByHouseId(long houseId);
	List<Home> findByAddress_City(String city);
	List<Home> findByBedroomsAndBathrooms(double bedrooms, double bathrooms);
}

//	public List<Home> findByPriceLessThan(double price);

