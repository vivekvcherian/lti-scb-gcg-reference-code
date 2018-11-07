package com.scb.validator.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scb.model.CustomerRequest;
import com.scb.validator.model.CustomerResponse;
import com.scb.validator.service.CustomerRequestService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerRequestServiceImpl implements CustomerRequestService {

	@Override
	public CustomerResponse customerRequestHandleService(CustomerRequest customerRequest) {
		
		return new CustomerResponse();
		
	}

}
