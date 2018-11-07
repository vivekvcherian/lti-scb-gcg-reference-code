package com.scb.validator.service;

import com.scb.model.CustomerRequest;
import com.scb.validator.model.CustomerResponse;

public interface CustomerRequestService {
	
	public CustomerResponse customerRequestHandleService(CustomerRequest customerRequest);

}
