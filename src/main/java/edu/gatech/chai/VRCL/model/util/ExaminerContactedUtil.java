
package edu.gatech.chai.VRCL.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Observation.ObservationStatus;

import edu.gatech.chai.USCore.model.util.CommonUtil;

public class ExaminerContactedUtil {
	public static final Observation.ObservationStatus status = ObservationStatus.FINAL;
	public static final CodeableConcept code = new CodeableConcept()
			.addCoding(new Coding().setSystem(CommonUtil.loincSystemUrl).setCode("74497-9")
					.setDisplay("Medical examiner or coroner was contacted"));
}