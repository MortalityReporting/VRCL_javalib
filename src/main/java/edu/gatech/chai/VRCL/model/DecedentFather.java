package edu.gatech.chai.VRCL.model;

import org.hl7.fhir.r4.model.RelatedPerson;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.VRCL.model.util.DecedentFatherUtil;

@ResourceDef(name = "RelatedPerson", profile = "http://hl7.org/fhir/us/VRCL/StructureDefinition/VRCL-decedent-father")
public class DecedentFather extends RelatedPerson {
	public DecedentFather() {
		super();
		CommonUtil.initResource(this);
		addRelationship(DecedentFatherUtil.code);
	}
}
