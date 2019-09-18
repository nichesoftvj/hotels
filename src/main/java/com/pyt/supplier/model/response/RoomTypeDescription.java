
package com.pyt.supplier.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "roomTypeId", "roomDescription" })
@Data
public class RoomTypeDescription {

	@JsonProperty("roomTypeId")
	public Integer roomTypeId;
	@JsonProperty("roomDescription")
	public String roomDescription;

}
