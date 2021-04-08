package com.training.studentproject;

public class Address {
	
	String building;
	String city;
	String zipcode;
	public Address(String building, String city, String zipcode) {
		this.building = building;
		this.city = city;
		this.zipcode = zipcode;
	}
	public String getBuilding() {
		return building;
	}
	public String getCity() {
		return city;
	}
	public String getZipcode() {
		return zipcode;
	}

}
