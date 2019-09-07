package com.pyt.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.supplier.model.Content;
import com.pyt.supplier.model.HotelAmenity;
import com.pyt.supplier.model.Image;
import com.pyt.supplier.model.LeadPassenger;
import com.pyt.supplier.model.OtherPassenger;
import com.pyt.supplier.model.PassengerConfiguration;
import com.pyt.supplier.model.PassengerInformation;
import com.pyt.supplier.model.Request;
import com.pyt.supplier.model.RoomTypeDescription;

@RestController
public class BasicController {

	static Logger logger = LoggerFactory.getLogger(BasicController.class);

	@RequestMapping(value = "content", produces = "application/json")
	public Content getSampleContent() {

		logger.info("getSampleContent service called");
		Content c = new Content();
		c.setName("Tregony Guest House");
		c.setStarRating(4);
		c.setAddress("1 Clodgy View, St Ives");
		c.setZipCode("TR26 1JG");
		c.setLatitude(50.212928771972656);
		c.setLongitude(-5.484310150146484);
		c.setImageURL("https://i.travelapi.com/hotels/3000000/2300000/2290700/2290694/f7da0abc_b.jpg");
		c.setInternetSource("EXPEDIA");
		c.setInternetHotelCode("275450");
		List<String> img = new ArrayList<>();
		img.add("https://i.travelapi.com/hotels/3000000/2300000/2290700/2290694/1cfc5b02_b.jpg");
		c.setOtherImages(img);
		c.setPropertyType(4);
		c.setTripAdvisorRating(5);
		HotelAmenity ameity = new HotelAmenity();
		ameity.setAmenityId(52);
		ameity.setAmenity("Total number of rooms -");

		List<HotelAmenity> amenities = new ArrayList<>();
		amenities.add(ameity);
		c.setHotelAmenities(amenities);

		c.setPropertyDescription("property description");
		List<Image> imagesList = new ArrayList<>();
		Image images = new Image();
		images.setHero(true);
		images.setHighResolutionUrl("https://i.travelapi.com/hotels/3000000/2300000/2290700/2290694/2e8884b6_z.jpg");
		images.setThumbnailUrl("https://i.travelapi.com/hotels/3000000/2300000/2290700/2290694/2e8884b6_t.jpg");
		images.setUrl("https://i.travelapi.com/hotels/3000000/2300000/2290700/2290694/2e8884b6_b.jpg");

		imagesList.add(images);
		c.setImages(imagesList);

		List<RoomTypeDescription> roomTypeDescriptionsList = new ArrayList<>();
		RoomTypeDescription roomType = new RoomTypeDescription();
		roomType.setRoomDescription("room desc");
		roomType.setRoomTypeId(313210);

		roomTypeDescriptionsList.add(roomType);
		c.setRoomTypeDescriptions(roomTypeDescriptionsList);
		return c;
	}

	@RequestMapping(value = "request", produces = "application/json")
	public Request sampleRequest() {
		logger.info("sampleRequest service called");
		Request r = new Request();

		r.setCheckInDate("23/May/2019");
		r.setCheckOutDate("27/May/2019");
		List<PassengerConfiguration> passengerConfigurationList = new ArrayList<>();
		PassengerConfiguration passengerConfig = new PassengerConfiguration();
		passengerConfig.setAdults(2);
		List<Integer> children = new ArrayList<>();
		children.add(1);
		children.add(2);
		passengerConfig.setChildren(children);
		PassengerConfiguration passengerConfig1 = new PassengerConfiguration();
		passengerConfig1.setAdults(3);
		passengerConfigurationList.add(passengerConfig1);
		passengerConfigurationList.add(passengerConfig);
		r.setPassengerConfiguration(passengerConfigurationList);

		List<String> hotelIds = new ArrayList<>();
		hotelIds.add("12345");
		hotelIds.add("45678");
		r.setHotelIds(hotelIds);

		r.setRateCode(123456789);
		r.setRoomTypeCode(2345678);

		PassengerInformation passengerInformation = new PassengerInformation();
		LeadPassenger leadPassenger = new LeadPassenger();
		leadPassenger.setAge(27);
		leadPassenger.setDateOfBirth("20/Nov/1991");
		leadPassenger.setFirstName("Aravinth");
		leadPassenger.setLastName("Chandramouli");
		leadPassenger.setSalutation("Mr.");
		passengerInformation.setLeadPassenger(leadPassenger);
		List<OtherPassenger> otherPassengerList = new ArrayList<>();
		OtherPassenger p1 = new OtherPassenger();
		p1.setAge(27);
		p1.setDateOfBirth("20/Nov/1991");
		p1.setFirstName("Aravinth");
		p1.setLastName("Chandramouli");
		p1.setSalutation("Mr.");
		otherPassengerList.add(p1);

		OtherPassenger p2 = new OtherPassenger();
		p2.setAge(27);
		p2.setDateOfBirth("20/Nov/1991");
		p2.setFirstName("Aravinth");
		p2.setLastName("Chandramouli");
		p2.setSalutation("Mr.");
		otherPassengerList.add(p2);
		passengerInformation.setOtherPassenger(otherPassengerList);
		r.setPassengerInformation(passengerInformation);

		return r;
	}
}
