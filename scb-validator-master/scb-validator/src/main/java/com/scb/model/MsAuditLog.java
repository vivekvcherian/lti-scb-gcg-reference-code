package com.scb.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
public class MsAuditLog implements Serializable {
	
	private static final long serialVersionUID = -1803780864651956194L;
	private long uuid;
	private long refId;
	private String transactionType;
	private String msComponent;
	private String logLevel;
	private String logMessage;
	private byte[] payload;
	private String timeStamp;
	

}
