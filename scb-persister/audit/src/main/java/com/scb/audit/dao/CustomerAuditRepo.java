package com.scb.audit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.audit.model.MsAuditLog;

public interface CustomerAuditRepo extends JpaRepository<MsAuditLog, Long> {

}
