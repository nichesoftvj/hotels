package com.pyt.supplier.service;

import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;

public interface BookingSerivice {

	Response booking(String hotelId, Request createRequest);

}
