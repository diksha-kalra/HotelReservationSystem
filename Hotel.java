package com.cg.hotelreservationprogram;

public class Hotel{
	private String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    
	public Hotel(String hotelName, int regularWeekDay, int regularWeekEnd) {
		super();
		this.hotelName = hotelName;
		this.regularWeekDay = regularWeekDay;
		this.regularWeekEnd = regularWeekEnd;
	}

	public String getHotelName() {
		return hotelName;
	}

	public int getRegularWeekDay() {
		return regularWeekDay;
	}

	public int getRegularWeekEnd() {
		return regularWeekEnd;
	}
}
