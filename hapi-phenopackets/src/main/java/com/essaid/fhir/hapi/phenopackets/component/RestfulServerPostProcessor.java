package com.essaid.fhir.hapi.phenopackets.component;

import ca.uhn.fhir.rest.server.RestfulServer;
import com.essaid.fhir.hapi.phenopackets.provider.PatientPhenopacketProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RestfulServerPostProcessor implements BeanPostProcessor {
  //private final RestfulServer restfulServer;
  
//  @Lazy
//  RestfulServerPostProcessor(RestfulServer restfulServer){
//    this.restfulServer = restfulServer;
//    System.out.println("===============  Constructed RestfulServerPostProcessor");
//  }
  
  @Autowired
  PatientPhenopacketProvider patientPhenopacketProvider;
//
//  @Autowired
//  ApplicationContext applicationContext;
  
  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //System.out.println("==========  POST:" + beanName);
    
    if(beanName.equals("restfulServer")){
      ((RestfulServer) bean).registerProvider(patientPhenopacketProvider);
      //restfulServer.registerProvider(applicationContext.getBean(PatientPhenopacketProvider.class));
      System.out.println("============= Registered PatientPhenopacketProvider");
    }
    
    return bean;
  }
}
