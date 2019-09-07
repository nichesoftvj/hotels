package com.pyt.supplier.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//import expedia.model.User;

@Mapper
public interface UserMapping {

	UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

	// UserPojo UserToUserPojo(User user);
}
