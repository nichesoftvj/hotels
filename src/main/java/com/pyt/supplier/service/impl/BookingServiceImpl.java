package com.pyt.supplier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.supplier.datarequest.BookingDao;
import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;
import com.pyt.supplier.service.BookingSerivice;

@Service
public class BookingServiceImpl implements BookingSerivice {

	@Autowired
	BookingDao bookingDao;

	@Override
	public Response booking(String hotelId, Request createRequest) {

		Response response = bookingDao.booking(hotelId, createRequest);
		return response;
	}

}
