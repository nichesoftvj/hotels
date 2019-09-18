
package com.pyt.supplier.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "starRating", "address", "contact", "zipCode", "latitude", "longitude", "imageURL",
		"internetSource", "internetHotelCode", "otherImages", "propertyType", "tripAdvisorRating", "hotelAmenities",
		"propertyDescription", "roomTypeDescriptions", "images" })
@Data
public class Content {

	@JsonProperty("name")
	public String name;
	@JsonProperty("starRating")
	public Integer starRating;
	@JsonProperty("address")
	public String address;
	@JsonProperty("contact")
	public String contact;
	@JsonProperty("zipCode")
	public String zipCode;
	@JsonProperty("latitude")
	public Double latitude;
	@JsonProperty("longitude")
	public Double longitude;
	@JsonProperty("imageURL")
	public String imageURL;
	@JsonProperty("internetSource")
	public String internetSource;
	@JsonProperty("internetHotelCode")
	public String internetHotelCode;
	@JsonProperty("otherImages")
	public List<String> otherImages = null;
	@JsonProperty("propertyType")
	public Integer propertyType;
	@JsonProperty("tripAdvisorRating")
	public Integer tripAdvisorRating;
	@JsonProperty("hotelAmenities")
	public List<HotelAmenity> hotelAmenities = null;
	@JsonProperty("propertyDescription")
	public String propertyDescription;
	@JsonProperty("roomTypeDescriptions")
	public List<RoomTypeDescription> roomTypeDescriptions = null;
	@JsonProperty("images")
	public List<Image> images = null;

}
