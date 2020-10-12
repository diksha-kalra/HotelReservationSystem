package com.cg.hotelreservationprogram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HotelReservation {

	private ArrayList<Hotel> listOfHotel = new ArrayList<>();

	public boolean addHotel(String hotelName, int regularWeekDay, int regularWeekEnd, int ratings,
			int rewardCustomerWeekDay, int rewardCustomerWeekEnd) {
		Hotel hotel = new Hotel(hotelName, regularWeekDay, regularWeekEnd, ratings, rewardCustomerWeekDay,
				rewardCustomerWeekEnd);
		listOfHotel.add(hotel);
		return true;
	}

	public void settotalRates(String startDay, String endDay, long dayRange, String type)throws InvalidEntriesException {
		long weekends = 0;
		if (startDay.equalsIgnoreCase("sun") || startDay.equalsIgnoreCase("sat")) {
			++weekends;
		}
		if (endDay.equalsIgnoreCase("sun") || endDay.equalsIgnoreCase("sat")) {
			++weekends;
		}
		Long weekdays = dayRange - weekends;
		try {
			if (type.equalsIgnoreCase("regular")) {
				for (Hotel hotel : listOfHotel) {
					Long totalRate = weekdays * hotel.getRegularWeekDay() + weekends * hotel.getRegularWeekEnd();
					hotel.setTotalRate(totalRate);
				}
			}
			else if (type.equalsIgnoreCase("rewards")) {
				for (Hotel hotel : listOfHotel) {
					Long totalRate = weekdays * hotel.getRewardCustomerWeekDay()
							+ weekends * hotel.getRewardCustomerWeekEnd();
					hotel.setTotalRate(totalRate);
					System.out.println(hotel.getTotalRate());
				}
			} else {
				throw new InvalidEntriesException("invalid customer type");
			}
		} catch (InvalidEntriesException e) {
			System.out.println(e);
		}
	}

	public Hotel cheapestHotel() {
		List<Hotel> sortedListOfHotel = listOfHotel.stream().sorted(Comparator.comparing(Hotel::getTotalRate))
				.collect(Collectors.toList());
		Hotel cheapestHotel = sortedListOfHotel.get(0);
		for (Hotel hotels : sortedListOfHotel) {
			if (hotels.getTotalRate() <= sortedListOfHotel.get(0).getTotalRate()) {
				if (hotels.getRatings() > sortedListOfHotel.get(0).getRatings()) {
					cheapestHotel = hotels;
				}
			} else {
				break;
			}
		}
		return cheapestHotel;
	}

	public Hotel determiningcheapestHotelBasedOnUserInput(String userInput) {
		Hotel cheapestHotel = null;
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
			e.printStackTrace();
		}
		long dateRange = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		try {
			if (dateRange > 0) {
				DateFormat format2 = new SimpleDateFormat("EE");
				String startDay = format2.format(startDate);
				String endDay = format2.format(endDate);
				settotalRates(startDay, endDay, dateRange, type);
				cheapestHotel = cheapestHotel();
			} else {
				throw new InvalidEntriesException("invalid date range");
			}
		} catch (InvalidEntriesException e) {
			System.out.println(e);
		}
		return cheapestHotel;
	}

	public static void main(String[] args){
		Scanner obj = new Scanner(System.in);
		System.out.println("Welcome To Hotel Reservation Program");
		HotelReservation addHotel = new HotelReservation();
		addHotel.addHotel("Lakewood", 110, 90, 3, 80, 80);
		addHotel.addHotel("Bridgewood", 150, 50, 4, 110, 50);
		addHotel.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		System.out.println("Enter the customer type and dates");
		System.out.println("Format- type:date1, date2.");
		String userInput = obj.nextLine();
		Hotel cheapestHotel = addHotel.determiningcheapestHotelBasedOnUserInput(userInput);
		System.out.println("Cheapest Hotel: " + cheapestHotel.getHotelName() + " rating: " + cheapestHotel.getRatings()
				+ " Total Rate: " + cheapestHotel.getTotalRate());
		obj.close();
	}
}
