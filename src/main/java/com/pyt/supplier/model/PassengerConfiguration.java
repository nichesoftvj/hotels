
package com.pyt.supplier.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "adults", "children" })
@Data
public class PassengerConfiguration {

	@JsonProperty("adults")
	public Integer adults;
	@JsonProperty("children")
	public List<Integer> children = null;

}
