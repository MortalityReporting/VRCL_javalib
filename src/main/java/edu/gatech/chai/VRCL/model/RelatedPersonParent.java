package edu.gatech.chai.VRCL.model;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.USCoreRelatedPerson;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.USCore.model.util.USCorePatientUtil;

@ResourceDef(name = "RelatedPersonParent", profile = "http://hl7.org/fhir/us/vr-common-library/StructureDefinition/RelatedPerson-parent-vr")
public class RelatedPersonParent extends USCoreRelatedPerson {

	public RelatedPersonParent() {
		super();
		CommonUtil.initResource(this);
	}

	public RelatedPersonParent(Reference patient) {
		super();
		CommonUtil.initResource(this);
		setPatient(patient);
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
}