package com.scb.model;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
	private static final long serialVersionUID = 1125749775288601451L;
	//@Column
	private long customerId;
	//@Column
	private String customerName;
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	//@Column
	private String customerAccType;
	//@Column
	private String customerRegion;
	//@Column 
	private String timeStamp;
	//@Column
	private long correlationId;
	//@Column
	private long transactionId;
	//@Column
	private String downStreamResponse;
}
