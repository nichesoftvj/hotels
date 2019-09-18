package com.pyt.supplier.service;

import com.pyt.supplier.model.response.Response;

import expedia.model.CreateItineraryRequest;

public interface BookingSerivice {
	
	Response booking(String hotelId, CreateItineraryRequest createRequest);

}
