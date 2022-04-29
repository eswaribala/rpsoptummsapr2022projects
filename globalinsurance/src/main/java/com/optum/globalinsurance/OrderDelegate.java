package com.optum.globalinsurance;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.optum.globalinsurance.models.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * This is an easy adapter implementation
 * illustrating how a Java Delegate can be used
 * from within a BPMN 2.0 Service Task.
 */
@Component("orderservice")
@Slf4j
public class OrderDelegate implements JavaDelegate {
	@Autowired
	private RestTemplate restTemplate;
    @Value("${orderUrl}")
	private String orderUrl;
  private final Logger LOGGER = Logger.getLogger(OrderDelegate.class.getName());
  
  public void execute(DelegateExecution execution) throws Exception {
    
    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
            + "activityName='" + execution.getCurrentActivityName() + "'"
            + ", activityId=" + execution.getCurrentActivityId()
            + ", processDefinitionId=" + execution.getProcessDefinitionId()
            + ", processInstanceId=" + execution.getProcessInstanceId()
            + ", businessKey=" + execution.getProcessBusinessKey()
            + ", executionId=" + execution.getId()
            + ", variables=" + execution.getVariables()
            + " \n\n");
    
    long orderId=Long.parseLong(execution.getVariable("orderId").toString());
    LocalDate orderDate=LocalDate.parse(execution.getVariable("orderDate").toString());
    long orderAmount=Long.parseLong(execution.getVariable("orderAmount").toString());
    
    Order order=new Order();
    order.setOrderId(orderId);
    order.setOrderDate(orderDate);
    order.setOrderAmount(orderAmount);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity request = new HttpEntity<>(order,headers);
    ResponseEntity<?> orderResponse=restTemplate.
		      postForEntity(orderUrl,request, String.class);
    log.info("Response Received as"+orderResponse.getBody());
    execution.setVariable("response", orderResponse.getBody());
    
  }

}
