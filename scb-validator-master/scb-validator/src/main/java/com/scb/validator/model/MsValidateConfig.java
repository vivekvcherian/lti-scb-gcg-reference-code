package com.scb.validator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder 
public class MsValidateConfig {
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int refId;
	//@Column
	private String fieldName;
	//@Column
	private String fieldValue;
	//@Column
	private int maxLength;
	//@Column
	private int minLength;
	//@Column
	private String isRequireToValidate;

}
