package com.pyt.supplier.service;

import java.util.List;

import com.pyt.supplier.model.request.Request;
import com.pyt.supplier.model.response.Response;

public interface SearchService {

	Response getSearchDetails(Request request);
}
