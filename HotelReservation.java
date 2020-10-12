package com.cg.hotelreservationprogram;

import java.util.ArrayList;

public class HotelReservation {

	private ArrayList<Hotel> listOfHotel = new ArrayList<>();

	public boolean addHotel(String hotelName, int regularWeekDay, int regularWeekEnd) {
		Hotel hotel = new Hotel(hotelName, regularWeekDay, regularWeekEnd);
		listOfHotel.add(hotel);
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Welcome To Hotel Reservation Program");
	}
}
