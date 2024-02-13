package edu.gatech.chai.VRCL.model;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.USCore.model.util.USCorePatientUtil;
import edu.gatech.chai.VRCL.model.util.PatientVitalRecordsUtil;

@ResourceDef(name = "Patient", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/vrdr-decedent")
public class Decedent extends Patient {

	public Decedent() {
		super();
		CommonUtil.initResource(this);
	}

	public Extension getRace() {
		return CommonUtil.getExtension(this, USCorePatientUtil.raceExtensionURL);
	}

	public Extension setRace(String ombCategory, Coding detailed, String text) {
		Extension extension = getRace();
		if (extension != null) {
			for (Extension subExtension : extension.getExtension()) {
				if (subExtension.getUrl().equals("ombCategory")) {
					((Coding) subExtension.getValue()).setCode(ombCategory);
				}
				if (subExtension.getUrl().equals("detailed")) {
					subExtension.setValue(detailed);
				}
				if (subExtension.getUrl().equals("text")) {
					subExtension.setValue(new StringType(text));
				}
			}
			return extension;
		}
		return addRace(ombCategory, detailed, text);
	}

	public Extension addRace(String ombCategory, Coding detailed, String text) {
		Extension extension = new Extension(USCorePatientUtil.raceExtensionURL);
		if(!ombCategory.isEmpty()) {
			Extension ombCategoryExt = new Extension("ombCategory",
					new Coding().setCode(ombCategory).setSystem(USCorePatientUtil.raceSystem));
			extension.addExtension(ombCategoryExt);
		}
		if(!detailed.isEmpty()) {
			Extension detailedExt = new Extension("detailed",detailed);
			extension.addExtension(detailedExt);
		}
		if(!text.isEmpty()) {
			Extension textExt = new Extension("text", new StringType(text));
			extension.addExtension(textExt);
		}
		this.addExtension(extension);
		return extension;
	}

	public Extension getEthnicity() {
		return CommonUtil.getExtension(this, USCorePatientUtil.ethnicityExtensionURL);
	}

	public Extension setEthnicity(String ombCategory, Coding detailed, String text) {
		Extension extension = getEthnicity();
		if (extension != null) {
			for (Extension subExtension : extension.getExtension()) {
				if (subExtension.getUrl().equals("ombCategory")) {
					((Coding) subExtension.getValue()).setCode(ombCategory);
				}
				if (subExtension.getUrl().equals("detailed")) {
					subExtension.setValue(detailed);
				}
				if (subExtension.getUrl().equals("text")) {
					subExtension.setValue(new StringType(text));
				}
			}
			return extension;
		}
		return addEthnicity(ombCategory, detailed, text);
	}

	public Extension addEthnicity(String ombCategory, Coding detailed, String text) {
		Extension extension = new Extension(USCorePatientUtil.ethnicityExtensionURL);
		if(!ombCategory.isEmpty()) {
			Extension ombCategoryExt = new Extension("ombCategory",
					new Coding().setCode(ombCategory).setSystem(USCorePatientUtil.ethnicitySystem));
			extension.addExtension(ombCategoryExt);
		}
		if(!detailed.isEmpty()) {
			Extension detailedExt = new Extension("detailed",detailed);
			extension.addExtension(detailedExt);
		}
		if(!text.isEmpty()) {
			Extension textExt = new Extension("text", new StringType(text));
			extension.addExtension(textExt);
		}
		this.addExtension(extension);
		return extension;
	}

	public Extension getSexAtDeath() {
		return CommonUtil.getExtension(this, USCorePatientUtil.sexAtDeathExtensionURL);
	}

	public Extension setSexAtDeath(String value) {
		CodeableConcept ccSAD = CommonUtil.findConceptFromCollectionUsingSimpleString(value, USCorePatientUtil.sexAtDeathSet);
		return setSexAtDeath(ccSAD);
	}
	
	public Extension setSexAtDeath(CodeableConcept value) {
		Extension extension = getSexAtDeath();
		if (extension == null) {
			extension = new Extension(USCorePatientUtil.sexAtDeathExtensionURL);
		}
		extension.setValue(value);
		this.addExtension(extension);
		return extension;
	}
	
	public Extension getSpouseAlive() {
		return CommonUtil.getExtension(this, USCorePatientUtil.spouseAliveExtensionURL);
	}

	public Extension setSpouseAlive(String value) {
		CodeableConcept ccSAD = CommonUtil.findConceptFromCollectionUsingSimpleString(value, USCorePatientUtil.spouseAliveSet);
		return setSpouseAlive(ccSAD);
	}
	
	public Extension setSpouseAlive(CodeableConcept value) {
		Extension extension = getSpouseAlive();
		if (extension == null) {
			extension = new Extension(USCorePatientUtil.spouseAliveExtensionURL);
		}
		extension.setValue(value);
		this.addExtension(extension);
		return extension;
	}

	public Extension getBirthPlace() {
		return CommonUtil.getExtension(this, PatientVitalRecordsUtil.birthPlaceExtensionURL);
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
		Extension extension = new Extension(PatientVitalRecordsUtil.birthPlaceExtensionURL);
		extension.setValue(address);
		this.addExtension(extension);
		return extension;
	}

	public Identifier addSSNIdentifier(String value) {
		Identifier identifier = new Identifier();
		identifier.setType(USCorePatientUtil.identifierTypeSSValue);
		identifier.setValue(value);
		identifier.setSystem(USCorePatientUtil.identifierSSSystem);
		addIdentifier(identifier);
		return identifier;
	}
	
	public Decedent setMaritalStatus(String maritalStatus) {
		CodeableConcept maritalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(maritalStatus, USCorePatientUtil.maritalStatusSet);
		this.setMaritalStatus(maritalStatusCC);
		return this;
	}
	
	public Decedent setMaritalStatus(String maritalStatus, CodeableConcept bypassEditFlag) {
		CodeableConcept maritalStatusCC = CommonUtil.findConceptFromCollectionUsingSimpleString(maritalStatus, USCorePatientUtil.maritalStatusSet);
		maritalStatusCC = maritalStatusCC.copy();
		if(bypassEditFlag != null) {
			Extension extension = new Extension();
			extension.setUrl(maritalStatus);
		}
		this.setMaritalStatus(maritalStatusCC);
		return this;
	}
	
	public Decedent addPartialBirthDateExtension(IntegerType year,String yearDataAbsentReason, IntegerType month,String monthDataAbsentReason,
			IntegerType day,String dayDataAbsentReason) {
		if(this.birthDate == null) {
			this.birthDate = new DateType();
		}
		Extension baseExtension = addPartialBirthDateBaseExtension();
		addPartialDateYear(baseExtension,year,yearDataAbsentReason);
		addPartialDateMonth(baseExtension,month,monthDataAbsentReason);
		addPartialDateDay(baseExtension,day,dayDataAbsentReason);
		this.birthDate.addExtension(baseExtension);
		return this;
	}
	
	private Extension addPartialBirthDateBaseExtension() {
		Extension baseExtension = new Extension(CommonUtil.partialDatePartAbsentReasonURL);
		return baseExtension;
	}
	
	private Decedent addPartialDateYear(Extension baseExtension, IntegerType year,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(year != null && !year.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateYearURL,year));
		}
		return this;
	}
	
	private Decedent addPartialDateMonth(Extension baseExtension, IntegerType month,String dataAbsentReason) {
		if(dataAbsentReason != null && !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(month != null && !month.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateMonthURL,month));
		}
		return this;
	}
	
	private Decedent addPartialDateDay(Extension baseExtension, IntegerType day,String dataAbsentReason) {
		if(dataAbsentReason != null || !dataAbsentReason.isEmpty()) {
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayAbsentReasonURL,CommonUtil.findCodeFromCollectionUsingSimpleString(dataAbsentReason, CommonUtil.dataAbsentReasonCodeSet)));
		}
		else if(day != null && !day.isEmpty()){
			baseExtension.addExtension(new Extension(CommonUtil.partialDateDateDayURL,day));
		}
		return this;
	}
	//TODO: Add handler for informant mapping
}
