package com.scb.audit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @XmlRootElement
public class MsAuditLog {
	@Column(name="transactionId")
	private long uuid;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long refId;
	@Column
	private String transactionType;
	@Column
	private String msComponent;
	@Column
	private String logLevel;
	@Column
	private String logMessage;
	@Lob
	private byte[] payload;
	@Column
	private String timeStamp;
}
