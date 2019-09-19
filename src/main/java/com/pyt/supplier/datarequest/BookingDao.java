package com.pyt.supplier.datarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyt.supplier.configuration.SignatureGenerator;
import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookingDao {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SignatureGenerator signatureGenerator;

	@Autowired
	ObjectMapper objectMapper;

	public Response booking(String hotelId, Request createRequest) {

		String signature = signatureGenerator.getSignature();
		System.out.println(signature);
		// map pyt request to Expedia request body

		// send booking details to Exp

		// extract token from price-check (might need to hit expedia for getting price
		// check details)

		// get expedia response.

		// check the status and set Respone object
		Response response = new Response();
		response.setStatus("Success for :" + hotelId);
		response.setBookingCost(12345);
		response.setConfirmationNumber(123456789);
		log.info("Booking Confirmed");
		return response;

	}
}
