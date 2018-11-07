package com.scb.downstreamstub.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.scb.downstreamstub.model.CustomerRequestData;
import com.scb.downstreamstub.model.CustomerResponse;
import com.scb.downstreamstub.service.CustomerRequestService;
import com.scb.downstreamstub.utils.PropertiesConfig;
import com.scb.downstreamstub.utils.SCBCommonMethods;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerRequestServiceImpl implements CustomerRequestService {
	@Autowired
	private SCBCommonMethods commonMethods;

	@Autowired
	private PropertiesConfig propertiesConfig;

	@Override
	public CustomerResponse customerRequestHandleService(CustomerRequestData customerRequestData) {
		//String response = readFile(propertiesConfig.getResponseFilePath());
		customerRequestData.setDownStreamResponse("Hello from downstream micro-services");
		return commonMethods.getSuccessResponse(customerRequestData);
	}

	public String readFile(String responseFilePath) {
		String responseContents = new String();
		try {
			File file = ResourceUtils.getFile(responseFilePath);
			responseContents = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			log.error("Error while reading file: " + e);
		}
		return responseContents;
	}
}
