package edu.gatech.chai.VRCL.model;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.util.CommonUtil;

@ResourceDef(name = "MotherVitalRecords", profile = "http://hl7.org/fhir/us/vr-common-library/StructureDefinition/Patient-mother-vr")
public class MotherVitalRecords extends PatientVitalRecords{
    
    public MotherVitalRecords() {
        super();
        CommonUtil.initResource(this);
    }
}