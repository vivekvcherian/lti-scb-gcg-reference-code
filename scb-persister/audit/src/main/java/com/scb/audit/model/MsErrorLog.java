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
public class MsErrorLog {
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
	private String errorMessage;
	@Column
	private String errorCode;
	@Lob
	private byte[] stackTrace;
	@Column
	private String timeStamp;

}
