package com.scb.audit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scb.audit.model.CustomerRequestData;
import java.lang.String;
import java.util.List;

public interface CustomerDataReposatory extends JpaRepository<CustomerRequestData, Long> {
	List<CustomerRequestData> findByCustomerNameAndCustomerId(String customername, long customerId);
	List<CustomerRequestData> findByCorrelationId(long correlationId);
	

}
