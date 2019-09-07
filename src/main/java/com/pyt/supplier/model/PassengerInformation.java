package com.pyt.supplier.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "leadPassenger", "otherPassengers" })
@Data
public class PassengerInformation {

	@JsonProperty("leadPassenger")
	public LeadPassenger leadPassenger;
	@JsonProperty("otherPassenger")
	public List<OtherPassenger> otherPassenger = null;

}