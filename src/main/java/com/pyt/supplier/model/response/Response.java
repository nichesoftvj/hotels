
package com.pyt.supplier.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "results", "roomTypeCode", "rateCode", "maxRoomOccupancy",
		"quotedRoomOccupancy", "roomsLeft", "refundable", "currency", "price", "basePrice", "rateKey",
		"cancellationPolicy", "expediaDetails", "islandHopperDetails" })
@Data
public class Response {

	@JsonProperty("results")
	public List<Result> results = null;

	//@JsonProperty("passengerConfiguration")
	//public PassengerConfiguration passengerConfiguration;
	@JsonProperty("roomTypeCode")
	public String roomTypeCode;
	@JsonProperty("rateCode")
	public String rateCode;
	@JsonProperty("maxRoomOccupancy")
	public Integer maxRoomOccupancy;
	@JsonProperty("quotedRoomOccupancy")
	public Integer quotedRoomOccupancy;
	@JsonProperty("roomsLeft")
	public Integer roomsLeft;
	@JsonProperty("refundable")
	public Boolean refundable;
	@JsonProperty("currency")
	public String currency;
	@JsonProperty("price")
	public Integer price;
	@JsonProperty("basePrice")
	public Integer basePrice;
	@JsonProperty("rateKey")
	public String rateKey;
	@JsonProperty("cancellationPolicy")
	public List<CancellationPolicy> cancellationPolicy = null;
	@JsonProperty("expediaDetails")
	public ExpediaDetails expediaDetails;
	@JsonProperty("islandHopperDetails")
	public IslandHopperDetails islandHopperDetails;

	@JsonProperty("status")
	public String status;
	@JsonProperty("bookingCost")
	public Integer bookingCost;
	@JsonProperty("confirmationNumber")
	public Integer confirmationNumber;

}
