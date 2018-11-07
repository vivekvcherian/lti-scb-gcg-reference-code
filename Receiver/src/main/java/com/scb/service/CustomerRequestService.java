package com.scb.service;

import com.scb.model.CustomerRequest;
import com.scb.model.CustomerResponse;

public interface CustomerRequestService {
	
	public CustomerResponse customerRequestHandleService(CustomerRequest customerRequest);

}
