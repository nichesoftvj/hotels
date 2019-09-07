
package com.pyt.supplier.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "callStatus", "hotelCode", "provider", "checkInDateMillis", "checkOutDateMillis", "rooms" })
@Data
public class Result {

	@JsonProperty("callStatus")
	public String callStatus;
	@JsonProperty("hotelCode")
	public String hotelCode;
	@JsonProperty("provider")
	public String provider;
	@JsonProperty("checkInDateMillis")
	public Integer checkInDateMillis;
	@JsonProperty("checkOutDateMillis")
	public Integer checkOutDateMillis;
	@JsonProperty("rooms")
	public List<Room> rooms = null;

}
