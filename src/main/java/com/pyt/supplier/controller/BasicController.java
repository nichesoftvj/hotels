package com.pyt.supplier.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyt.supplier.model.base.LeadPassenger;
import com.pyt.supplier.model.base.OtherPassenger;
import com.pyt.supplier.model.base.PassengerConfiguration;
import com.pyt.supplier.model.base.PassengerInformation;
import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.CancellationPolicy;
import com.pyt.supplier.model.response.Content;
import com.pyt.supplier.model.response.ExpediaDetails;
import com.pyt.supplier.model.response.HotelAmenity;
import com.pyt.supplier.model.response.Image;
import com.pyt.supplier.model.response.IslandHopperDetails;
import com.pyt.supplier.model.response.Response;
import com.pyt.supplier.model.response.Result;
import com.pyt.supplier.model.response.Room;
import com.pyt.supplier.model.response.RoomOffer;
import com.pyt.supplier.model.response.RoomTypeDescription;
import com.pyt.supplier.model.response.Surcharges;

import expedia.model.BillingContact;
import expedia.model.BillingContactAddress;
import expedia.model.Conversations;
import expedia.model.Itinerary;
import expedia.model.ItineraryAdjustment;
import expedia.model.ItineraryConfirmationId;
import expedia.model.ItineraryLinks;
import expedia.model.ItineraryLinks1;
import expedia.model.ItineraryLinks1Cancel;
import expedia.model.ItineraryLinks1Change;
import expedia.model.ItineraryLinksCancel;
import expedia.model.ItineraryRate;
import expedia.model.ItineraryRate.MerchantOfRecordEnum;
import expedia.model.ItineraryRateCancelPenalties;
import expedia.model.ItineraryRateCancelRefund;
import expedia.model.ItineraryRateDepositPolicies;
import expedia.model.ItineraryRateFees;
import expedia.model.ItineraryRateFees.FrequencyEnum;
import expedia.model.ItineraryRateFees.ScopeEnum;
import expedia.model.ItineraryRatePromotions;
import expedia.model.ItineraryRateStay;
import expedia.model.ItineraryRateStay.TypeEnum;
import expedia.model.ItineraryRooms;
import expedia.model.ItineraryRooms.StatusEnum;
import expedia.model.Link;
import expedia.model.Phone;
import expedia.model.ValueAdd;
import expedia.model.ValueAdds;

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
	
	@RequestMapping(value = "response", produces = "application/json")
	public Response getSampleResponse() {
		Response resp = new Response();
		resp.setStatus("success");
		resp.setBasePrice(40000);
		resp.setCurrency("INR");
		resp.setMaxRoomOccupancy(1);
		resp.setPrice(25000);
		resp.setRateCode("12345");
		resp.setRateKey("abc-def-geh");
		resp.setRefundable(true);
		resp.setRoomsLeft(5);
		resp.setRoomTypeCode("12345");
		List<CancellationPolicy> cancellationPolicy = new ArrayList<>();
		CancellationPolicy cancelPolicy = new CancellationPolicy();
		cancelPolicy.setFrom("25/Aug/2019");
		cancelPolicy.setTo("6/Oct/2019");
		cancelPolicy.setPenalty(15000);
		cancellationPolicy.add(cancelPolicy );
		resp.setCancellationPolicy(cancellationPolicy );
		
		ExpediaDetails expediaDetails = new ExpediaDetails();
		expediaDetails.setCustomerIpAddress("abc");
		expediaDetails.setCustomerSessionId("abc");
		expediaDetails.setCustomerUserAgent("abc");
		expediaDetails.setMandatoryTax(25000);
		expediaDetails.setMemberOnlyDeal(true);
		expediaDetails.setRateType("MerchantPackage");
		expediaDetails.setSalePrice(true);
		Surcharges surcharges = new Surcharges();
		surcharges.setFee(15000);
		surcharges.setTax(25000);
		expediaDetails.setSurcharges(surcharges );
		resp.setExpediaDetails(expediaDetails );
		
		IslandHopperDetails islandHopperDetails = new IslandHopperDetails();
		islandHopperDetails.setAvailCode("C");
		islandHopperDetails.setBookable(true);
		islandHopperDetails.setMealCode("FB30%");
		islandHopperDetails.setMealType("Full Board");
		islandHopperDetails.setRateIncludes("20% offer, honeymoon inclusions, etc");
		RoomOffer roomOffer = new RoomOffer();
		islandHopperDetails.setRoomOffer(roomOffer );
		resp.setIslandHopperDetails(islandHopperDetails );
		
		PassengerConfiguration passengerConfiguration = new PassengerConfiguration();
		passengerConfiguration.setAdults(2);
		List<Integer> children = new ArrayList<>();
		children.add(1);
		children.add(2);
		passengerConfiguration.setChildren(children );
		//resp.setPassengerConfiguration(passengerConfiguration );
		
		List<Result> results = new ArrayList<Result>();
		Result result = new Result();
		result.setCallStatus("SUCCESS/FAILED");
		result.setCheckInDateMillis(12345677);
		result.setCheckOutDateMillis(12345677);
		result.setHotelCode("12345");
		result.setProvider("Expedia");
		List<Room> rooms = new ArrayList<Room>();
		Room room = new Room();
		room.setBasePrice(40000);
		room.setCancellationPolicy(cancellationPolicy);
		room.setCurrency("INR");
		room.setExpediaDetails(expediaDetails);
		room.setIslandHopperDetails(islandHopperDetails);
		room.setMaxRoomOccupancy(4);
		room.setPassengerConfiguration(passengerConfiguration);
		room.setPrice(25000);
		room.setQuotedRoomOccupancy(2);
		room.setRateCode("12345");
		room.setRateKey("abc-def-ghi");
		room.setRefundable(true);
		room.setRoomsLeft(5);
		room.setRoomTypeCode("12345");
		rooms.add(room );
		result.setRooms(rooms );
		results.add(result );
		
		
		resp.setResults(results );
		
		return resp;
	}
	@RequestMapping(value = "book", produces = "application/json")
	public Response getBookingStatus() {
		Response resp = new Response();
		resp.setStatus("Success");
		resp.setBookingCost(12345678);
		resp.setConfirmationNumber(123456789);
		return resp;
	}
	
	@RequestMapping(value = "retrive", produces = "application/json")
	public Itinerary getRetriveBooking() {
		Itinerary itineary = new Itinerary();
		itineary.setItineraryId("8999989898988");
		itineary.setAffiliateMetadata("This booking was made with EPS.");
		itineary.setAffiliateReferenceId("4480ABC");
		BillingContact billingContact = new BillingContact();
		BillingContactAddress address = new BillingContactAddress();
		address.setCity("Seattle");
		address.setCountryCode("US");
		address.setLine1("555 1st St");
		address.setLine2("10th Floor");
		address.setLine3("Unit 12");
		address.setPostalCode("98121");
		address.setStateProvinceCode("WA");
		billingContact.setAddress(address );
		billingContact.setEmail("Email");
		billingContact.setFamilyName("familu name");
		billingContact.setGivenName("giveno");
		Phone phone = new Phone();
		phone.setAreaCode("80");
		phone.setCountryCode("+91");
		phone.setNumber("123456");
		billingContact.setPhone(phone );
		itineary.setBillingContact(billingContact );
		
		Conversations conversations = new Conversations();
		Map<String, Link> conversLinks = new HashMap<>();
		Link value = new Link();
		value.setHref("https://www.example.com?key=123abd456");
		value.setMethod("GET");
		conversLinks.put("property", value);
		conversations.setLinks(conversLinks );
		itineary.setConversations(conversations );
		
		itineary.setCreationDateTime("2018-09-21");
		ItineraryLinks links = new ItineraryLinks();
		ItineraryLinksCancel cancel = new ItineraryLinksCancel();
		cancel.setHref("/2.3/itineraries/8999989898988?token=MY5S3j36cOcLfLBZjPYQ1abhfc8CqmjmFVzkk7euvWaunE57LLeDgaxm516m");
		cancel.setMethod("DELETE");
		links.setCancel(cancel );
		itineary.setLinks(links );
		
		itineary.setPropertyId("8150374");
		List<ItineraryRooms> rooms = new ArrayList<ItineraryRooms>();
		ItineraryRooms room = new ItineraryRooms();
		BigDecimal childAgesItem = new BigDecimal(14);
		room.addChildAgesItem(childAgesItem);
		room.setBedGroupId("d395b56d-d31d-4a84-ad2b-66820b1d48e2");
		room.setCheckin("2018-09-21");
		room.setCheckout("2018-09-26");
		room.setNumberOfAdults(new BigDecimal(2));
		List<BigDecimal> childAges = new ArrayList<BigDecimal>();
		childAges.add(new BigDecimal(2));
		childAges.add(new BigDecimal(3));
		room.setChildAges(childAges );
		room.setGivenName("Givenne");
		room.setFamilyName("Nameo");
		room.setStatus(StatusEnum.BOOKED );
		room.setSpecialRequest("Please give me extra towels.");
		room.setSmoking(false);
		room.setId("926784314");
		ItineraryConfirmationId confirmationId = new ItineraryConfirmationId();
		confirmationId.setExpedia("1234567890");
		confirmationId.setProperty("BEF23123AA");
		room.setConfirmationId(confirmationId );
		ItineraryRate rate = new ItineraryRate();
		rate.setId("035943984");
		rate.setMerchantOfRecord(MerchantOfRecordEnum.EXPEDIA );
		rate.setRefundable(true);
		ItineraryRateCancelRefund cancelRefund = new ItineraryRateCancelRefund();
		cancelRefund.setAmount("123.98");
		cancelRefund.setCurrency("USD");
		rate.setCancelRefund(cancelRefund);
		List<BigDecimal> amenities = new ArrayList<BigDecimal>();
		amenities.add(new BigDecimal(12345));
		amenities.add(new BigDecimal(678));
		amenities.add(new BigDecimal(999));
		rate.setAmenities(amenities);
		
		ItineraryRatePromotions promotions = new ItineraryRatePromotions();
		ValueAdds valueAdds = new ValueAdds();
		ValueAdd valueAdd = new ValueAdd();
		valueAdd.setDescription("10 USD credit on activities and sports for your stay.");
		valueAdd.setId("123abc");
		valueAdds.put("123abc", valueAdd );
		ValueAdd valueMP = new ValueAdd();
		valueMP.setDescription("20% discount on theme park tickets purchased through the concierge desk.");
		valueMP.setId("3x4mp13");
		valueAdds.put("3x4mp13", valueMP );
		promotions.setValueAdds(valueAdds );
		rate.setPromotions(promotions );
		
		List<List<ItineraryRateStay>> nightly = new ArrayList<List<ItineraryRateStay>>();
		List<ItineraryRateStay> night = new ArrayList<ItineraryRateStay>();
		ItineraryRateStay nig = new ItineraryRateStay();
		//
		nig.setCurrency("USD");
		nig.setType(TypeEnum.BASE_RATE);
		nig.value("111.23");
		night.add(nig );
		nightly.add(night );
		//rate.setNightly(nightly);
		
		List<ItineraryRateStay> stay = new ArrayList<ItineraryRateStay>();
		ItineraryRateStay sty = new ItineraryRateStay();
		
		sty.setCurrency("USD");
		sty.setType(TypeEnum.BASE_RATE);
		sty.value("111.23");
		stay.add(sty);
		rate.setStay(stay );
		
		List<ItineraryRateCancelPenalties> cancelPenalties = new ArrayList<ItineraryRateCancelPenalties>();
		ItineraryRateCancelPenalties cp = new ItineraryRateCancelPenalties();
		cp.setAmount("250.75");
		cp.setCurrency("USD");
		cp.setEnd("2018-12-12T01:01:01.000-08:00");
		cp.setNights("2");
		cp.setPercent("30%");
		cp.setStart("2018-01-01T01:01:01.000-08:00");
		cancelPenalties.add(cp );
		rate.setCancelPenalties(cancelPenalties );
		
		List<ItineraryRateDepositPolicies> depositPolicies = new ArrayList<ItineraryRateDepositPolicies>();
		ItineraryRateDepositPolicies dP = new ItineraryRateDepositPolicies();
		dP.setAmount("220.75");
		dP.setDue("2018-12-12T01:01:01.000-08:00");
		depositPolicies.add(dP );
		rate.setDepositPolicies(depositPolicies );
		
		List<ItineraryRateFees> fees = new ArrayList<ItineraryRateFees>();
		ItineraryRateFees fee = new ItineraryRateFees();
		fee.setCurrency("USD");
		fee.setFrequency(FrequencyEnum.PER_DAY);
		fee.setScope(ScopeEnum.PER_ACCOMMODATION);
		fee.setType(expedia.model.ItineraryRateFees.TypeEnum.RESORT_FEE);
		fee.setValue("20.75");
		fees.add(fee );
		rate.setFees(fees);
		
		room.setRate(rate );
		ItineraryLinks1 roomLinks = new ItineraryLinks1();
		ItineraryLinks1Cancel cancel1 = new ItineraryLinks1Cancel();
		cancel1.setHref("href");
		cancel1.setMethod("GET");
		roomLinks.setCancel(cancel1 );
		ItineraryLinks1Change change1 = new ItineraryLinks1Change();
		change1.setHref("href");
		change1.setMethod("GET");
		roomLinks.setChange(change1);
		room.setLinks(roomLinks );
		rooms.add(room );
		itineary.setRooms(rooms );
		ItineraryAdjustment adjustment = new ItineraryAdjustment();
		adjustment.setCurrency("USD");
		adjustment.setType("base_rate");
		adjustment.setValue("-100.00");
		itineary.setAdjustment(adjustment );
		return itineary;
	}
}
