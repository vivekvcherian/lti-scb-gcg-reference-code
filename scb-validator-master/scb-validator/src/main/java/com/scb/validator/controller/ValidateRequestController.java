package com.scb.validator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.validator.model.CustomerRequestData;
import com.scb.validator.model.CustomerValidateResponse;
import com.scb.validator.service.CustomerRequestValidateService;
import com.scb.validator.utils.ReceiverConstants;

@RestController
@RequestMapping(ReceiverConstants.CUSTOMER_VALIDATE_URL)
public class ValidateRequestController {
	@Autowired
	private CustomerRequestValidateService customerRequestValidateService;

	@RequestMapping(value = ReceiverConstants.CUSTOMER_VALIDATE_REQUEST_HANDLE_URL, produces = { "application/json", "application/xml" })
	public ResponseEntity<CustomerValidateResponse> customerRequestHandle(@RequestBody CustomerRequestData customerRequestData) {
		CustomerValidateResponse customerValidateResponse = customerRequestValidateService.validateCustomerRequest(customerRequestData);
		
		return new ResponseEntity<CustomerValidateResponse>(customerValidateResponse, HttpStatus.OK);
	}

	
}
