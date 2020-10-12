package com.cg.hotelreservationprogram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HotelReservation {

	private ArrayList<Hotel> listOfHotel = new ArrayList<>();

	public boolean addHotel(String hotelName, int regularWeekDay, int regularWeekEnd) {
		Hotel hotel = new Hotel(hotelName, regularWeekDay, regularWeekEnd);
		listOfHotel.add(hotel);
		return true;
	}

	public Hotel totalRates(String startDay, String endDay, long dayRange) {
		long weekends = 0;
		if (startDay.equalsIgnoreCase("sun") || startDay.equalsIgnoreCase("sat")) {
			++weekends;
		}
		if (endDay.equalsIgnoreCase("sun") || endDay.equalsIgnoreCase("sat")) {
			++weekends;
		}
		Long weekdays = dayRange - weekends;
		for (Hotel hotel : listOfHotel) {
			Long totalRate = weekdays * hotel.getRegularWeekDay() + weekends * hotel.getRegularWeekEnd();
			hotel.setTotalRate(totalRate);
			System.out.println(totalRate);
		}

		Hotel cheapestHotel = listOfHotel.stream().sorted(Comparator.comparing(Hotel::getTotalRate)).findFirst()
				.orElse(null);
		return cheapestHotel;
	}

	public Hotel determiningcheapestHotelBasedOnUserInput(String userInput) throws ParseException {
		Date startDate = null, endDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy");
		int index = userInput.indexOf(":");
		String type = userInput.substring(0, index);
		int startDateIndex1 = 0, startDateIndex2 = 0;
		startDateIndex1 = userInput.indexOf(":");
		startDateIndex2 = userInput.indexOf(",");
		int endDateIndex1 = 0, endDateIndex2 = 0;
		endDateIndex1 = userInput.indexOf(", ");
		endDateIndex2 = userInput.indexOf(".");
		try {
			startDate = formatter.parse(userInput.substring(startDateIndex1 + 1, startDateIndex2));
			endDate = formatter.parse(userInput.substring(endDateIndex1 + 2, endDateIndex2));
		} catch (ParseException e) {
			System.out.println("give input in proper format");
		}
		long dateRange = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		DateFormat format2 = new SimpleDateFormat("EE");
		String startDay = format2.format(startDate);
		String endDay = format2.format(endDate);
		Hotel cheapestHotel = totalRates(startDay, endDay, dateRange);
		return cheapestHotel;
	}

	public static void main(String[] args) throws ParseException {
		Scanner obj = new Scanner(System.in);
		System.out.println("Welcome To Hotel Reservation Program");
		System.out.println("Enter the customer type and dates");
		System.out.println("Format- type:date1, date2.");
		String userInput = obj.nextLine();
		HotelReservation addHotel = new HotelReservation();
		addHotel.addHotel("Lakewood", 110, 90);
		addHotel.addHotel("Bridgewood", 150, 50);
		addHotel.addHotel("Ridgewood", 220, 150);
		Hotel cheapestHotel = addHotel.determiningcheapestHotelBasedOnUserInput(userInput);
		System.out.println(
				"Cheapest Hotel-" + cheapestHotel.getHotelName() + " Total Rate-" + cheapestHotel.getTotalRate());
		obj.close();
	}
}
