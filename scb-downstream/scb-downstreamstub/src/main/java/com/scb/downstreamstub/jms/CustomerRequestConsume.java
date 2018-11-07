package com.scb.downstreamstub.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.scb.downstreamstub.model.CustomerRequestData;

import lombok.extern.log4j.Log4j2;

@Component @Log4j2
public class CustomerRequestConsume {
	
	  /*@JmsListener(destination = "CustomerRequestData", containerFactory = "myFactory")
	  public void receiveMessage(CustomerRequestData customerRequestData) {
		  log.debug("consume message from JMS queue"+ "Received <" + customerRequestData.toString() + ">");
	  }
	  */
	 

}
