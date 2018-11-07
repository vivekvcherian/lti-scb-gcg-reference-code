package com.scb.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class MsErrorLog implements Serializable {
	
	private static final long serialVersionUID = 2418205900831020548L;
	private long uuid;
	private long refId;
	private String transactionType;
	private String msComponent;
	private String errorMessage;
	private String errorCode;
	private byte[] stackTrace;
	private String timeStamp;

}
