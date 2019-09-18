package com.pyt.supplier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyt.supplier.datarequest.SearchDao;
//import com.pyt.supplier.mapper.SearchMapper;
import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;
import com.pyt.supplier.service.SearchService;

import expedia.model.PropertyAvailabilities;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao;
	
	//@Autowired
	//private SearchMapper searchMapper;
	
	@Override
	public Response getSearchDetails(Request request) {
		
		PropertyAvailabilities propertyAvailabities = searchDao.getSearchResults(request);
		
		//Response searchResult=searchMapper.mapSearchResultToResponse(propertyAvailabities);
		return null;
	}

}
