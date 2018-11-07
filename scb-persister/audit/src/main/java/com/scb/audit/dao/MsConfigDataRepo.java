package com.scb.audit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.scb.audit.model.MsConfig;

public interface MsConfigDataRepo extends JpaRepository<MsConfig, Integer> {
	
	
	/*@Query("select t.isDuplicateCheckRequire from MsConfig t where t.countryCode = ?1 AND t.transactionName = ?2")
	String retrieveIsDuplicateCheckRequire(String countryCode, String transactionName );
	*/
	@Query("select t.value_1 from MsConfig t where t.country= ?1 AND t.trx_desc= ?2 AND t.validation = ?3")
	String getDuplicateParamValue(String country, String trx_desc, String validation );
	
}
