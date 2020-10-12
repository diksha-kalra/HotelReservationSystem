package com.cg.hotelreservationprogram;

public class Hotel{
	private String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    private Long totalRate;
    private int ratings;
    private int rewardCustomerWeekDay;
    private int rewardCustomerWeekEnd;
    
	public Hotel(String hotelName, int regularWeekDay, int regularWeekEnd,int ratings,int rewardCustomerWeekDay,int rewardCustomerWeekEnd) {
		super();
		this.hotelName = hotelName;
		this.regularWeekDay = regularWeekDay;
		this.regularWeekEnd = regularWeekEnd;
		this.ratings=ratings;
		this.rewardCustomerWeekEnd=rewardCustomerWeekEnd;
		this.rewardCustomerWeekDay=rewardCustomerWeekDay;
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

	public int getRewardCustomerWeekDay() {
		return rewardCustomerWeekDay;
	}

	public int getRewardCustomerWeekEnd() {
		return rewardCustomerWeekEnd;
	}
}
