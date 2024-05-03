package com.example.HousingApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "home")
public class Home {

	@Column(name = "price")
	private Double price;

	@Column(name = "bedrooms")
	private Double bedrooms;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long houseId;

	@Column(name = "bathrooms")
	private Double bathrooms;

	@Column(name = "sqft_living")
	private Long sqft_living;

	@Column(name = "sqft_lot")
	private Long sqft_lot;

	@Column(name = "floors")
	private Double floors;

	@Column(name = "waterfront")
	private int waterfront;

	@Column(name = "view")
	private int view;

	@Column(name = "sqft_above")
	private Long sqft_above;

	@Column(name = "sqft_basement")
	private Long sqft_basement;

	@Column(name = "yr_built")
	private int yr_built;

	@Column(name = "yr_renovated")
	private int yr_renovated;



	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;

//	public Home() {
//		// Default constructor
//	}

//	public Home(Double price, Double bedrooms, Double bathrooms, Long sqft_living, Long sqft_lot, Double floors,
//				int waterfront, int view, int condition, Long sqft_above, Long sqft_basement, int yr_built, int yr_renovated , Address address)
//			 {
//		this.price = price;
//		this.bedrooms = bedrooms;
//		this.bathrooms = bathrooms;
//		this.sqft_living = sqft_living;
//		this.sqft_lot = sqft_lot;
//		this.floors = floors;
//		this.waterfront = waterfront;
//		this.view = view;
//		this.condition = condition;
//		this.sqft_above = sqft_above;
//		this.sqft_basement = sqft_basement;
//		this.yr_built = yr_built;
//		this.yr_renovated = yr_renovated;
//		this.address = address;
//
//	}

	// Getters and setters for other properties


	public Long getHouseId() {
		return houseId;
	}

	public void setHouseId(Long houseId) {
		this.houseId = houseId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// Include getters and setters for other properties


	public Double getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Double bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Double getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Double bathrooms) {
		this.bathrooms = bathrooms;
	}

	public Long getSqft_living() {
		return sqft_living;
	}

	public void setSqft_living(Long sqft_living) {
		this.sqft_living = sqft_living;
	}

	public Long getSqft_lot() {
		return sqft_lot;
	}

	public void setSqft_lot(Long sqft_lot) {
		this.sqft_lot = sqft_lot;
	}

	public Double getFloors() {
		return floors;
	}

	public void setFloors(Double floors) {
		this.floors = floors;
	}

	public int getWaterfront() {
		return waterfront;
	}

	public void setWaterfront(int waterfront) {
		this.waterfront = waterfront;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}



	public Long getSqft_above() {
		return sqft_above;
	}

	public void setSqft_above(Long sqft_above) {
		this.sqft_above = sqft_above;
	}

	public Long getSqft_basement() {
		return sqft_basement;
	}

	public void setSqft_basement(Long sqft_basement) {
		this.sqft_basement = sqft_basement;
	}

	public int getYr_built() {
		return yr_built;
	}

	public void setYr_built(int yr_built) {
		this.yr_built = yr_built;
	}

	public int getYr_renovated() {
		return yr_renovated;
	}

	public void setYr_renovated(int yr_renovated) {
		this.yr_renovated = yr_renovated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
