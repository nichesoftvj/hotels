package com.pyt.supplier.datarequest;

import java.lang.reflect.Type;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pyt.supplier.configuration.SignatureGenerator;
import com.pyt.supplier.model.request.Request;

import expedia.model.PropertyAvailabilities;
import expedia.model.PropertyAvailability;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SearchDao {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SignatureGenerator signatureGenerator;

	@Autowired
	ObjectMapper objectMapper;

	// @Autowired
	// SearchMapper searchMapper;

	public PropertyAvailabilities getSearchResults(Request request) {
		try {

			String url = "https://test.ean.com/2.3/properties/availability";

			HttpHeaders requestHeader = new HttpHeaders();
			requestHeader.set("Accept", MediaType.APPLICATION_JSON_VALUE);
			requestHeader.set("Accept-Encoding", "application/gzip");
			requestHeader.set("Authorization", signatureGenerator.getSignature());
			requestHeader.set("Customer-Ip", "11.11.11.11");
			requestHeader.set("User-Agent", "TravelNow/3.30.112");
			requestHeader.set("Content-Type", "application/json;charset=UTF-8");
			requestHeader.set("Test", "standard");

			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
					.queryParam("business_model", "expedia_collect").queryParam("language", "en-US")
					.queryParam("partner_point_of_sale", "B2C_SA_PKG_NON_MOD").queryParam("billing_terms", "EAC")
					.queryParam("payment_terms", "0").queryParam("checkin", "2019-10-15")
					.queryParam("checkout", "2019-10-17").queryParam("currency", "USD").queryParam("country_code", "US")
					.queryParam("occupancy", "2-9,4").queryParam("property_id", "19")
					.queryParam("sales_channel", "website").queryParam("sales_environment", "hotel_package")
					.queryParam("sort_type", "preferred").queryParam("rate_plan_count", "1");

			HttpEntity<String> entity = new HttpEntity<String>(requestHeader);
			log.info("Search DataRequest Call  ");

			ResponseEntity<String> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
					String.class);
			System.out.println(responseEntity.getStatusCodeValue());
			System.out.println(responseEntity.getBody());

			JsonNode jsonResponse = objectMapper.readTree(responseEntity.getBody());
			// System.out.println(jsonResponse.size());
			System.out.println(jsonResponse.get(0).get("property_id"));
			System.out.println();
			Object json = objectMapper.readValue(jsonResponse.toString(), Object.class);
			System.out.println(json);

			ObjectMapper mapper = new ObjectMapper();
			Object json2 = mapper.readValue(jsonResponse.toString(), Object.class);
			String data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json2);
			// System.out.println(data);

			Gson g = new Gson();
//			Type collectionType = new TypeToken<Collection<Codebeautify>>() {
//			}.getType();
//			Collection<Codebeautify> enums = g.fromJson(data, collectionType);
//			System.out.println(enums.size());
//			for (Codebeautify e : enums) {
//				System.out.println(e.getProperty_id());
//			}

			Type propertyAvailabilityType = new TypeToken<Collection<PropertyAvailability>>() {
			}.getType();
			Collection<PropertyAvailability> propertyAvailabilities = g.fromJson(data, propertyAvailabilityType);
			System.out.println(propertyAvailabilities.size());
			for (PropertyAvailability propertyAvailability : propertyAvailabilities) {
				System.out.println(propertyAvailability.getPropertyId());
			}

//			 ResponseEntity<PropertyAvailabilities> responseEntity =
//			 restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
//			 PropertyAvailabilities.class);

			log.info("Search DataRequest--->Status : " + responseEntity.getStatusCode().toString());
			Collection<PropertyAvailability> propertyAvailability = propertyAvailabilities;
			// List<PropertyAvailabilities> list = responseEntity.getBody();
			// searchMapper.mapSearchResultToResponse(propertyAvailability);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
