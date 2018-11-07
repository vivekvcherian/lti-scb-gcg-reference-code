package com.scb.audit.service;

import com.scb.audit.model.MsAuditLog;
import com.scb.audit.model.CustomerRequestData;
import com.scb.audit.model.CustomerResponse;
import com.scb.audit.model.MsErrorLog;

public interface CustomerRequestService {
	
	public CustomerResponse customerRequestHandleService(CustomerRequestData customerRequestData);

	public MsAuditLog customerAuditRequestHandleService(MsAuditLog auditLog);

	public MsErrorLog customerErrorRequestHandleService(MsErrorLog msErrorLog);

}
