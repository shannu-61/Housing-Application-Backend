package com.example.HousingApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;



@Entity
@Table(name = "address")
public class Address {

	@Column(name = " street")
	String street;

	@Column(name = " city")
	String city;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int addressId;

	@Column(name = " statezip")
	String statezip;


	@Column(name = " country")
	String country;

	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private  Home home;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStatezip() {
		return statezip;
	}

	public void setStatezip(String statezip) {
		this.statezip = statezip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
