package com.scb.validator.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.scb.model.CustomerRequest;
import com.scb.validator.model.CustomerRequestData;
import com.scb.validator.model.CustomerResponse;
import com.scb.model.MsErrorLog;

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
				.timeStamp(getCurrentDateTime()).correlationId(customerRequest.getCorrelationId())
				.transactionId(getTransactionId()).build();
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
		if (null == customerRequest) {
			return false;
		} else if (null == customerRequest.getCustomerName()) {
			return false;
		} else if (customerRequest.getCustomerId() == 0) {
			return false;
		} else if ("USA".equals(customerRequest.getCustomerRegion())) {
			return false;
		} else if (customerRequest.getCorrelationId() == 0) {
			return false;
		}
		return true;
	}

	public CustomerResponse getErrorResponse(String errorMessage) {
		return CustomerResponse.builder().responseCode(400).responseMessage(errorMessage).build();
	}

	private long getTransactionId() {
		Random random = new Random(System.nanoTime() % 100000);
		long uniqueTansactionId = random.nextInt(1000000000);
		return uniqueTansactionId;
	}



	// convert object to toByteArray 
	public static byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return bytes;
	}

	public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		} finally {
			if (bis != null) {
				bis.close();
			}
			if (ois != null) {
				ois.close();
			}
		}
		return obj;
	}

	public MsErrorLog getErrorLogDetails(Exception e) {
		MsErrorLog errorLog = MsErrorLog.builder().errorMessage(e.getMessage()).msComponent("Router").stackTrace(toByteArray(e)).build();
		
		return errorLog;
	}
}
