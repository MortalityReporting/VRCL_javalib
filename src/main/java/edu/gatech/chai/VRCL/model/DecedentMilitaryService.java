package edu.gatech.chai.VRCL.model;

import java.math.BigDecimal;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.VRCL.model.util.DecedentMilitaryServiceUtil;
import edu.gatech.chai.VRCL.model.util.DecedentUsualWorkUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/VRCL/StructureDefinition/VRCL-decedent-military-service")
public class DecedentMilitaryService extends Observation {
	public DecedentMilitaryService() {
		super();
		CommonUtil.initResource(this);
		setStatus(DecedentMilitaryServiceUtil.status);
		setCode(DecedentMilitaryServiceUtil.code);
	}
	
	public DecedentMilitaryService(CodeableConcept yesNoUnknownCode) {
		this();
		this.setValue(yesNoUnknownCode);
	}
	public DecedentMilitaryService(String code) {
		this();
		this.setValue(code);
	}
	
	public void setValue(String code) {
		CodeableConcept concept = CommonUtil.findConceptFromCollectionUsingSimpleString(code, CommonUtil.yesNoUnknownSet);
		if(concept != null) {
			setValue(concept);
		}
	}
	
	public void addUsualOccupationDuration(Integer years) {
		ObservationComponentComponent component = new ObservationComponentComponent();
		component.setCode(DecedentUsualWorkUtil.componentUsualOccupationDuraction);
		Quantity yearsQuantity = new Quantity();
		yearsQuantity.setCode("a");
		yearsQuantity.setSystem("http://unitsofmeasure.org");
		yearsQuantity.setValue(new BigDecimal(years));
		component.setValue(yearsQuantity);
		addComponent(component);
	}
}