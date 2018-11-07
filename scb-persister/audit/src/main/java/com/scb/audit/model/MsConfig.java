package com.scb.audit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import com.scb.audit.model.CustomerRequestData.CustomerRequestDataBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @XmlRootElement
public class MsConfig {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int msRefId;	
	@Column
	private String trx_desc;                                                     
	@Column
	private String country;                                                      
	@Column
	private String validation; 
	@Column
	private String field_1;
	@Column
	private String value_1;
	
}
