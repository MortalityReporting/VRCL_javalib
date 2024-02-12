package edu.gatech.chai.VRCL.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.USCore.model.util.CommonUtil;

public class ConditionContributingToDeathUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding(CommonUtil.loincSystemUrl, "69441-4", "Other significant causes or conditions of death"));
}
