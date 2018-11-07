package com.scb.downstreamstub.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) @ToString
public class CustomerResponse {
	
	private long responseCode;
	private String responseMessage;
	//@XmlElement(name = "CustomerResponse")
	private CustomerRequestData customerRequestData;

}
