package com.scb.model;

import javax.xml.bind.annotation.XmlRootElement;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString @XmlRootElement
public class CustomerValidateResponse {
	private long responseCode;
	private String responseMessage;
	private boolean isValidRequest;
	private CustomerRequestData customerRequestData;
	private String downstream_protocol;
	

}
