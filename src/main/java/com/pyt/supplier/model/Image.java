
package com.pyt.supplier.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "url", "thumbnailUrl", "highResolutionUrl", "hero" })
@Data
public class Image {

	@JsonProperty("url")
	public String url;
	@JsonProperty("thumbnailUrl")
	public String thumbnailUrl;
	@JsonProperty("highResolutionUrl")
	public String highResolutionUrl;
	@JsonProperty("hero")
	public Boolean hero;

}
