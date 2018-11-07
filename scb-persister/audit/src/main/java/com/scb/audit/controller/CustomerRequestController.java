package com.scb.audit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scb.audit.model.CustomerRequestData;
import com.scb.audit.model.CustomerResponse;
import com.scb.audit.model.MsAuditLog;
import com.scb.audit.model.MsErrorLog;
import com.scb.audit.service.CustomerRequestService;
import com.scb.audit.utils.ReceiverConstants;


@RestController
@RequestMapping(ReceiverConstants.AUDIT_URL)
public class CustomerRequestController {
	@Autowired
	private CustomerRequestService customerRequestService;
	

	@RequestMapping(value = ReceiverConstants.CUSTOMER_REQUEST_HANDLE_URL, method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public ResponseEntity<CustomerResponse> customerRequestHandle(@RequestBody CustomerRequestData customerRequestData) {
		CustomerResponse customerResponse= customerRequestService.customerRequestHandleService(customerRequestData);
		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = ReceiverConstants.CUSTOMER_ADUIT_LOG_URL, method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public ResponseEntity<MsAuditLog> auditLogRequestHandle(@RequestBody MsAuditLog auditLog) {
		MsAuditLog responseAuditLog = customerRequestService.customerAuditRequestHandleService(auditLog);
		return new ResponseEntity<MsAuditLog>(responseAuditLog, HttpStatus.OK);
	}
	

	@RequestMapping(value = ReceiverConstants.CUSTOMER_ERROR_LOG_URL, method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public ResponseEntity<MsErrorLog> errorLogRequestHandle(@RequestBody MsErrorLog msErrorLog) {
		MsErrorLog responseErrorLog = customerRequestService.customerErrorRequestHandleService(msErrorLog);
		return new ResponseEntity<MsErrorLog>(responseErrorLog, HttpStatus.OK);
	}
	
	
}
