package com.cg.hotelreservationprogram;

public class Hotel{
	private String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    private Long totalRate;
    private int ratings;
    
	public Hotel(String hotelName, int regularWeekDay, int regularWeekEnd,int ratings) {
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

	public Long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(Long totalRate) {
		this.totalRate = totalRate;
	}

	public int getRatings() {
		return ratings;
	}
}
