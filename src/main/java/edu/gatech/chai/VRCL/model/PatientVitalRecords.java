package edu.gatech.chai.VRCL.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.USCorePatient;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.USCore.model.util.USCorePatientUtil;

@ResourceDef(name = "VitalRecordsPatient", profile = "http://hl7.org/fhir/us/vr-common-library/StructureDefinition/Patient-vr")
public class PatientVitalRecords extends USCorePatient{
    
    public PatientVitalRecords() {
        super();
        CommonUtil.initResource(this);
    }
    public Extension getBirthPlace() {
		return CommonUtil.getExtension(this, USCorePatientUtil.birthPlaceExtensionURL);
	}

	public Extension setBirthPlace(Address address) {
		Extension extension = getBirthPlace();
		if (extension != null) {
			extension.setValue(address);
			return extension;
		}
		return addBirthPlace(address);
	}

	public Extension addBirthPlace(Address address) {
		Extension extension = new Extension(USCorePatientUtil.birthPlaceExtensionURL);
		extension.setValue(address);
		this.addExtension(extension);
		return extension;
	}

	public Identifier addSSNIdentifier(String value) {
		return addIdentifier(USCorePatientUtil.identifierTypeSSValue, USCorePatientUtil.identifierSSSystem, value);
	}

    public Identifier addMRNIdentifier(String system, String value) {
		return addIdentifier(USCorePatientUtil.identifierTypeMRValue, system, value)
	}

    public Identifier addIdentifier(CodeableConcept type, String system, String value) {
		Identifier identifier = new Identifier();
		identifier.setType(type);
		identifier.setValue(value);
		identifier.setSystem(system);
		addIdentifier(identifier);
		return identifier;
	}
}
