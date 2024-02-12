package edu.gatech.chai.VRCL.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.USCorePatient;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.USCore.model.util.USCorePatientUtil;
import edu.gatech.chai.VRCL.model.util.VRPatientUtil;

@ResourceDef(name = "PatientMotherVitalRecords", profile = "http://hl7.org/fhir/us/vr-common-library/StructureDefinition/Patient-mother-vr")
public class PatientMotherVitalRecords extends USCorePatient {

	public PatientMotherVitalRecords() {
		super();
		CommonUtil.initResource(this);
	}
}