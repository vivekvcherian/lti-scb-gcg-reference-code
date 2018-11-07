package com.scb.downstreamstub.jms;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import com.scb.model.CustomerRequestData;

import lombok.extern.log4j.Log4j2;

@Component @Log4j2
public class JMSCorrelationalConfig {

	@Autowired
	private JmsTemplate jmsTemplate;

	public CustomerRequestData send(CustomerRequestData customerRequestData) {
		//final String correlationId = UUID.randomUUID().toString();
		String correlationId = Long.toString(customerRequestData.getCorrelationId());
		// Set the JMSCorrelationID
		jmsTemplate.convertAndSend("CustomerRequestData", customerRequestData, new CorrelationIdPostProcessor(correlationId));
		// Synchronous call, retrieve the message
		/*
		 * String responseMessage = (String)
		 * jmsTemplate.receiveSelectedAndConvert("CustomerResponseData",
		 * "JMSCorrelationID='" + correlationId + "'");
		 */
		//"JMSCorrelationID =	'" + correlationId + "'");
		String resSelectorId = "JMSCorrelationID = '" + customerRequestData.getCorrelationId() + "'";
		CustomerRequestData responseMessage =   (CustomerRequestData) jmsTemplate.receiveSelectedAndConvert("CustomerResponseData", resSelectorId);
		responseMessage.setDownStreamResponse("Success message from MQ");
		return responseMessage;
	}
	 @JmsListener(destination = "CustomerRequestData", containerFactory = "myFactory")
	  public void receiveMessage( CustomerRequestData customerRequestData) {
		 //CustomerRequestData customerRequestData = (CustomerRequestData) o;
		 customerRequestData.setDownStreamResponse("Success message from MQ");
		 log.debug("consume message from JMS queue "+ "Received <" + customerRequestData.toString() + ">");
		  String correlationId = Long.toString(customerRequestData.getCorrelationId());
		  jmsTemplate.convertAndSend("CustomerResponseData", customerRequestData, new CorrelationIdPostProcessor(correlationId));
	  }

	private class CorrelationIdPostProcessor implements MessagePostProcessor {
		private final String correlationId;

		public CorrelationIdPostProcessor(final String correlationId) {
			this.correlationId = correlationId;
		}

		@Override
		public Message postProcessMessage(final Message msg) throws JMSException {
			msg.setJMSCorrelationID(correlationId);
			return msg;
		}
	}

}
