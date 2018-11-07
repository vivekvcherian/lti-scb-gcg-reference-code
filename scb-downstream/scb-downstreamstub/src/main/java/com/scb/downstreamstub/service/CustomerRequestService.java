package com.scb.downstreamstub.service;

import com.scb.downstreamstub.model.CustomerRequest;
import com.scb.downstreamstub.model.CustomerRequestData;
import com.scb.downstreamstub.model.CustomerResponse;

public interface CustomerRequestService {
	
	public CustomerResponse customerRequestHandleService(CustomerRequestData customerRequestData);

}
