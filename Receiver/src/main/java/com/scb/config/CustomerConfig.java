package com.scb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;

@Component
@Getter
public class CustomerConfig {

	@Value("${GCG.downStreamURL}")
	private String downStreamURL;

	@Value("${GCG.auditLogURL}")
	private String auditLogURL;

	@Value("${GCG.errorLogURL}")
	private String errorLogURL;

	@Value("${GCG.customerRequestPersist}")
	private String customerRequestPersistURL;
	
	@Value("${GCG.customerValidator}")
	private String customerValidatorURL;
	
	@Value("${GCG.enableAuditLog}")
	private String isEnableAuditLog;
	
	@Value("${GCG.downstreamCallConfig}")
	private String downstreamCallConfig;
	
	@Value("${GCG.jmsTemplateTimeout}")
	private int jmsTemplateTimeout;
	
	@Value("${GCG.jmsRequestQueue}")
	private String jmsRequestQueue;
	
	@Value("${GCG.jmsResponseQueue}")
	private String jmsResponseQueue;

}
