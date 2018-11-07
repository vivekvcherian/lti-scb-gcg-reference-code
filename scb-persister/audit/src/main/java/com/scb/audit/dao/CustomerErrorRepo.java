package com.scb.audit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.audit.model.MsErrorLog;

public interface CustomerErrorRepo extends JpaRepository<MsErrorLog, Long> {

}
