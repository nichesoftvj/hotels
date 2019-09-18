package com.pyt.supplier.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.pyt.supplier.model.response.Response;

import expedia.model.PropertyAvailability;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SearchMapper {

	// @Mapping(target = "results.hotelCode", source =
	// "PropertyAvailabilities.property_id")
//	@Mapping(target = "results.hotelCode", expression = "PropertyAvailabilities != null && !PropertyAvailabilities.isEmpty() ? PropertyAvailabilities.get(0).getProperty_id : null")
//	Response mapSearchResultToResponse(PropertyAvailabilities propertyAvailabilities);

	@Mapping(target = "results.hotelCode", expression = "PropertyAvailabilities != null && !PropertyAvailabilities.isEmpty() ? PropertyAvailabilities.get(0).getProperty_id : null")
	Response mapSearchResultToResponse(Collection<PropertyAvailability> propertyAvailability);
}
