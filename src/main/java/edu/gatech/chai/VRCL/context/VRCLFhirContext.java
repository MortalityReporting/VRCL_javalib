package edu.gatech.chai.VRCL.context;

import org.hl7.fhir.r4.model.Bundle;

import ca.uhn.fhir.context.FhirContext;

public class VRCLFhirContext {
    FhirContext ctx;
    public VRCLFhirContext() {
        super();
        ctx = FhirContext.forR4();
        ctx.setDefaultTypeForProfile("http://hl7.org/fhir/us/vr-common-library/StructureDefinition/Observation-autopsy-performed-indicator-vr",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DeathRecordUpdateMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DeathRecordVoidMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DeathRecordAliasMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-StatusMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-CauseOfDeathCodingMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-CauseOfDeathCodingUpdateMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DemographicsCodingMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DemographicsCodingUpdateMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-AcknowledgementMessage",
                Bundle.class);
        ctx.setDefaultTypeForProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-ExtractionErrorMessage",
                Bundle.class);
    }
}
