package edu.gatech.chai.VRCL.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

import edu.gatech.chai.USCore.model.util.CommonUtil;

public class ManualUnderlyingCauseOfDeathUtil {
	public static final CodeableConcept code = new CodeableConcept().addCoding(new Coding(CommonUtil.loincSystemUrl, "80359-3", "Cause of death.underlying [Manual]"));
}