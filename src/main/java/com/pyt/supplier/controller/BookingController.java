package com.pyt.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;
import com.pyt.supplier.service.BookingSerivice;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
@RequestMapping("hotels")
public class BookingController {

	@Autowired
	private BookingSerivice bookingService;

	@PostMapping(value = "/{hotelId}/book", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Book a room for given hotel id")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public Response booking(@PathVariable String hotelId, @RequestBody Request createRequest) {

		Response response = new Response();
		try {
			response = bookingService.booking(hotelId, createRequest);
		} catch (Exception e) {
			log.error("Exception: " + e.getMessage());
		}
		return response;
	}
}
