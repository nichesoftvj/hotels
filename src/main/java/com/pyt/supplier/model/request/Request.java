
package com.pyt.supplier.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.pyt.supplier.model.base.PassengerConfiguration;
import com.pyt.supplier.model.base.PassengerInformation;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "checkInDate", "checkOutDate", "passengerConfiguration", "passengerInformation", "hotelIds" })
@Data
public class Request {

	@JsonProperty("checkInDate")
	public String checkInDate;
	@JsonProperty("checkOutDate")
	public String checkOutDate;
	@JsonProperty("passengerConfiguration")
	public List<PassengerConfiguration> passengerConfiguration = null;
	@JsonProperty("hotelIds")
	public List<String> hotelIds = null;
	@JsonProperty("rateCode")
	public Integer rateCode;
	@JsonProperty("roomTypeCode")
	public Integer roomTypeCode;

	@JsonProperty("passengerInformation")
	public PassengerInformation passengerInformation;

}
