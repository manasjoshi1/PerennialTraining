package com.rits.training;

public class PhoneNumber {
	String areaCode;
	String stdCode;
	String number;
	public PhoneNumber(String areaCode, String stdCode, String number) {
		super();
		this.areaCode = areaCode;
		this.stdCode = stdCode;
		this.number = number;
	}
	public PhoneNumber() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PhoneNumber [areaCode=" + areaCode + ", stdCode ="+stdCode+", number=" + number+" ]";
				
	}
	

}
