package com.scb.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString @XmlRootElement
public class CustomerRequest {
	private long customerId;
	private String customerName;
	private int serviceId;
	private String customerAccType;
	private String customerRegion;
	private long correlationId;
}
