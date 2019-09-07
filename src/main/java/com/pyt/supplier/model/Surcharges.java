
package com.pyt.supplier.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Tax", "Fee" })
@Data
public class Surcharges {

	@JsonProperty("Tax")
	public Integer tax;
	@JsonProperty("Fee")
	public Integer fee;

}
