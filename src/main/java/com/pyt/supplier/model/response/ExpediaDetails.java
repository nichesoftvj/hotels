
package com.pyt.supplier.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "customerSessionId", "customerIpAddress", "customerUserAgent", "salePrice", "memberOnlyDeal",
		"rateType", "surcharges", "mandatoryTax" })
@Data
public class ExpediaDetails {

	@JsonProperty("customerSessionId")
	public String customerSessionId;
	@JsonProperty("customerIpAddress")
	public String customerIpAddress;
	@JsonProperty("customerUserAgent")
	public String customerUserAgent;
	@JsonProperty("salePrice")
	public Boolean salePrice;
	@JsonProperty("memberOnlyDeal")
	public Boolean memberOnlyDeal;
	@JsonProperty("rateType")
	public String rateType;
	@JsonProperty("surcharges")
	public Surcharges surcharges;
	@JsonProperty("mandatoryTax")
	public Integer mandatoryTax;

}
