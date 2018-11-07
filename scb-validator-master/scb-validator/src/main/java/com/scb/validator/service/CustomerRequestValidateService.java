package com.scb.validator.service;

import com.scb.validator.model.CustomerRequestData;
import com.scb.validator.model.CustomerValidateResponse;

public interface CustomerRequestValidateService {
	
	public CustomerValidateResponse validateCustomerRequest(CustomerRequestData customerRequestData);

}
