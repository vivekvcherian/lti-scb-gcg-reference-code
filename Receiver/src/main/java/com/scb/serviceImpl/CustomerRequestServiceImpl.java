package com.scb.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.scb.config.CustomerConfig;
import com.scb.dao.CustomerDataReposatory;
import com.scb.model.CustomerRequest;
import com.scb.model.CustomerRequestData;
import com.scb.model.CustomerResponse;
import com.scb.model.MsAuditLog;
import com.scb.service.CustomerRequestService;
import com.scb.utils.SCBCommonMethods;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerRequestServiceImpl implements CustomerRequestService {
	@Autowired
	private SCBCommonMethods commonMethods;
	@Autowired
	private CustomerConfig propertiesConfig;
	@Autowired
	private GcgInternalApiCall gcgInternalApiCall;
	@Autowired
	private JMSCorrelationalConfig jmsCorrelationalConfig;

	@Override
	public CustomerResponse customerRequestHandleService(CustomerRequest customerRequest) {
		CustomerRequestData customerRequestData = commonMethods.getCustomerDataFromRequest(customerRequest);
		ResponseEntity<MsAuditLog> msAuditLogApiResponse = null;
		if (propertiesConfig.getIsEnableAuditLog().equalsIgnoreCase("yes")) {
			MsAuditLog parseAuditLog = commonMethods.getAuditLogDetails(customerRequestData);
			msAuditLogApiResponse = gcgInternalApiCall.msAuditLogApiCall(parseAuditLog);
		}
		
		ResponseEntity<CustomerResponse> customerResponseFromPersistDb = null;
		ResponseEntity<CustomerResponse> customerResponseFromvalidator = gcgInternalApiCall.msValidatorCall(customerRequestData);
		String downstreamProtocol = customerResponseFromvalidator.getBody().getResponseMessage();
		log.debug("Down stream protocol: .."+downstreamProtocol);
		if(customerResponseFromvalidator.getBody().getResponseCode() == 200){
			customerResponseFromPersistDb = gcgInternalApiCall
					.msCustomerPersistApiCall(customerRequestData);
		}else{
			return customerResponseFromvalidator.getBody();
		}
		
	//	ResponseEntity<CustomerResponse> customerResponseFromPersistDb = gcgInternalApiCall.msCustomerPersistApiCall(customerRequestData);
		ResponseEntity<CustomerResponse> customerResponseFromDownStream = null;
		if (customerResponseFromPersistDb.getBody().getResponseCode() == 200) {
			
			if(downstreamProtocol.trim().equalsIgnoreCase("JMS")){
				log.debug("JMS call ");
				CustomerRequestData customerRequestDataFromJMS = jmsCorrelationalConfig.send(customerResponseFromPersistDb.getBody().getCustomerRequestData());
				return commonMethods.getSuccessResponse(customerRequestDataFromJMS, "Successful response from JMS");
			} else if(downstreamProtocol.trim().equalsIgnoreCase("HTTP")){
				customerResponseFromDownStream = gcgInternalApiCall
						.msDownStreamCall(customerResponseFromPersistDb.getBody().getCustomerRequestData());
			}
			else{
				customerResponseFromDownStream = gcgInternalApiCall
						.msDownStreamCall(customerResponseFromPersistDb.getBody().getCustomerRequestData());
			}
			
		} else {
			return customerResponseFromPersistDb.getBody();
		}
		
		return  customerResponseFromDownStream.getBody();
	}

}
