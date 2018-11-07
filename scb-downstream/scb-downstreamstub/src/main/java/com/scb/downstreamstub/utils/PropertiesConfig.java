package com.scb.downstreamstub.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component @Getter
public class PropertiesConfig {

	@Value("${GCG.successResponseFilePath}")
	private String responseFilePath;
	
}
