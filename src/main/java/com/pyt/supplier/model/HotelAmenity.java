
package com.pyt.supplier.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "amenityId", "amenity" })
@Data
public class HotelAmenity {

	@JsonProperty("amenityId")
	public Integer amenityId;
	@JsonProperty("amenity")
	public String amenity;

}
