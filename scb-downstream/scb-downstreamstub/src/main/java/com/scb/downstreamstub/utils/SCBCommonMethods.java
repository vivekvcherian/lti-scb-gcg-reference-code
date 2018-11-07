package com.scb.downstreamstub.utils;

import java.time.LocalDateTime;
import java.util.Random;
//import org.hamcrest.text.IsEmptyString;
import org.springframework.stereotype.Component;
import com.scb.downstreamstub.model.CustomerRequest;
import com.scb.downstreamstub.model.CustomerRequestData;
import com.scb.downstreamstub.model.CustomerResponse;

@Component
public class SCBCommonMethods {

	public String getCurrentDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime.toString();
	}

	public CustomerRequestData getCustomerDataFromRequest(CustomerRequest customerRequest) {
		CustomerRequestData customerDataReposatory = CustomerRequestData.builder()
				.customerAccType(customerRequest.getCustomerAccType()).customerId(customerRequest.getCustomerId())
				.customerName(customerRequest.getCustomerName()).customerRegion(customerRequest.getCustomerRegion())
				.timeStamp(getCurrentDateTime()).correlationId(customerRequest.getCorrelationId()).transactionId(getTransactionId()).build();
		return customerDataReposatory;
	}

	public CustomerResponse getSuccessResponse(CustomerRequestData customerRequestData) {
		return CustomerResponse.builder().customerRequestData(customerRequestData).responseCode(200)
				.responseMessage("Success").build();
	}

	public CustomerResponse getErrorResponse() {
		return CustomerResponse.builder().responseCode(400).responseMessage("Bad request").build();

	}

	public CustomerResponse getErrorResponse(int errorCode, String errorMessage) {
		return CustomerResponse.builder().responseCode(errorCode).responseMessage(errorMessage).build();

	}
	
	
	public boolean isValidateCustomerRequest(CustomerRequest customerRequest) {
		if(null == customerRequest){
			return false;
		} else if(null == customerRequest.getCustomerName()){
			return false;			
		} else if(customerRequest.getCustomerId() == 0 ){
			return false;
		}else if("USA".equals(customerRequest.getCustomerRegion())){
			return false;
		}else if(customerRequest.getCorrelationId() == 0){
			return false;
		}
		return true;
	}

	public CustomerResponse getErrorResponse(String errorMessage) {
		return CustomerResponse.builder().responseCode(400).responseMessage(errorMessage).build();
	}

	private long getTransactionId(){
		Random random = new Random(System.nanoTime() % 100000);
		long uniqueTansactionId = random.nextInt(1000000000);
		return uniqueTansactionId;
	}
}
