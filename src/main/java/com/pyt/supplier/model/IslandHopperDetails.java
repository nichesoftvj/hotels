
package com.pyt.supplier.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "availCode", "rateIncludes", "mealType", "mealCode", "bookable", "roomOffer" })
@Data
public class IslandHopperDetails {

	@JsonProperty("availCode")
	public String availCode;
	@JsonProperty("rateIncludes")
	public String rateIncludes;
	@JsonProperty("mealType")
	public String mealType;
	@JsonProperty("mealCode")
	public String mealCode;
	@JsonProperty("bookable")
	public Boolean bookable;
	@JsonProperty("roomOffer")
	public RoomOffer roomOffer;

}
