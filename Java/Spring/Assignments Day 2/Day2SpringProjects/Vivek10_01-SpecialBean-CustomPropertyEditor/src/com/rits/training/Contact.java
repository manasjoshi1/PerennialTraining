package com.rits.training;

public class Contact {
	PhoneNumber phone;

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [phone=" + phone + "]";
	}
	

}
