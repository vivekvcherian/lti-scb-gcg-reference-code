package com.scb.audit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @XmlRootElement @XmlAccessorType(XmlAccessType.FIELD) 
public class CustomerRequestData {
	@Column
	private long customerId;
	@Column
	private String customerName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;
	@Column
	private String customerAccType;
	@Column
	private String customerRegion;
	@Column 
	private String timeStamp;
	@Column
	private long correlationId;
	@Column
	private long transactionId;
	@Column
	private String downStreamResponse;
}
