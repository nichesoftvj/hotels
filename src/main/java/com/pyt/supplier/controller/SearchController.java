package com.pyt.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;
import com.pyt.supplier.service.SearchService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@EnableAutoConfiguration
@Slf4j
@RequestMapping("hotel")
public class SearchController {

	@Autowired
	private SearchService searchService;

	@PostMapping(value = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("search for a hotels")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public Response getHotelSearch(@RequestBody Request searchRequest) {

		Response response = new Response();
		try {
			response = searchService.getSearchDetails(searchRequest);
		} catch (Exception e) {
			log.error("Exception: " + e.getMessage());
		}
		return response;
	}
}
