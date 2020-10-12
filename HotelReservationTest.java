package com.cg.hotelreservationprogram;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void addHotelWithNameAndRatesForRegularCustomer() {
		HotelReservation addHotel = new HotelReservation();
		boolean hotelAdded = addHotel.addHotel("Lakewood", 110, 90,3);
		Assert.assertEquals(true, hotelAdded);
	}
}