package com.essaid.fhir.hapi.phenopackets;

import com.essaid.fhir.hapi.phenopackets.component.ScanComponents;
import com.essaid.fhir.hapi.phenopackets.provider.ScanProviders;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan(basePackageClasses = {ScanProviders.class, ScanComponents.class})
public class PhenopacketsConfiguration {
}
