package com.revature.waterplant.model;

import java.time.LocalDate;

public class Stock {

	private int availableCans;
	
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAvailableCans() {
		return availableCans;
	}

	public void setAvailableCans(int availableCans) {
		this.availableCans = availableCans;
	}
	
}
