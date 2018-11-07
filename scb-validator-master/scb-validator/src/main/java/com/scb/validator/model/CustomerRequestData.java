package com.scb.validator.model;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @XmlRootElement @XmlAccessorType(XmlAccessType.FIELD) @ToString
public class CustomerRequestData implements Serializable {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1125749775288601451L;
	public long customerId;
	public String customerName;
	public int serviceId;
	public String customerAccType;
	public String customerRegion;
	public String timeStamp;
	public long correlationId;
	public long transactionId;
	public String downStreamResponse;
}
