package com.pyt.supplier.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "firstName", "lastName", "dateOfBirth", "age", "salutation" })
@Data
public class UserDetails {

	@JsonProperty("firstName")
	public String firstName;
	@JsonProperty("lastName")
	public String lastName;
	@JsonProperty("dateOfBirth")
	public String dateOfBirth;
	@JsonProperty("age")
	public Integer age;
	@JsonProperty("salutation")
	public String salutation;

}
