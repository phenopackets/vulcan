package com.essaid.fhir.hapi.phenopackets.provider;

import ca.uhn.fhir.model.valueset.BundleTypeEnum;
import ca.uhn.fhir.rest.annotation.Operation;
import ca.uhn.fhir.rest.server.IResourceProvider;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientPhenopacketProvider implements IResourceProvider {
  PatientPhenopacketProvider() {
    System.out.println("================================= PatientPhenopacketProvider constructed  " +
        "=============================");
  }
  
  @Operation(name = "$helloPhenopacket", bundleType = BundleTypeEnum.DOCUMENT,idempotent = true )
  public Bundle helloPhenopacket(){
    Bundle bundle = new Bundle();
    bundle.setId("hello-phenopacket");
    return  bundle;
  }
  
  @Override
  public Class<? extends IBaseResource> getResourceType() {
    return Patient.class;
  }
}
