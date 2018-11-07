package com.scb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.scb.model.CustomerRequest;
import com.scb.model.CustomerResponse;
import com.scb.service.CustomerRequestService;
import com.scb.utils.ReceiverConstants;
import com.scb.utils.SCBCommonMethods;

import lombok.extern.log4j.Log4j2;


@RestController @Log4j2
@RequestMapping(ReceiverConstants.CUSTOMER_URL)
public class CustomerRequestController {
	@Autowired
	private CustomerRequestService customerRequestService;
	@Autowired
	private SCBCommonMethods commonMethods;

	@RequestMapping(value = ReceiverConstants.CUSTOMER_REQUEST_HANDLE_URL, method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public CustomerResponse customerRequestHandle(@RequestBody CustomerRequest customerRequest) {
		log.info("Request received "+ customerRequest.toString());
		CustomerResponse customerResponse = new CustomerResponse();
		
		customerResponse = customerRequestService.customerRequestHandleService(customerRequest);
		/*if (commonMethods.isValidateCustomerRequest(customerRequest)) {
			customerResponse = customerRequestService.customerRequestHandleService(customerRequest);
		} else {
			log.info(" Validation failed");
			customerResponse = commonMethods.getErrorResponse("Request Validation Error");
		}*/
		log.info("Response: "+customerResponse.toString());
		return customerResponse;
	}

	@RequestMapping(value = ReceiverConstants.CUSTOMER_REQUEST_HANDLE_URL_REQUEST)
	public CustomerRequest customerRequestHandleExampleRequest() {

		return CustomerRequest.builder().customerAccType("Saving").customerId(22).customerName("Test Customer")
				.customerRegion("India").correlationId(200).build();
		// return
		// customerRequestService.customerRequestHandleService(customerRequest);

	}

}
