package edu.gatech.VRDR.model;

import org.hl7.fhir.dstu3.model.Attachment;
import org.hl7.fhir.dstu3.model.DocumentReference;
import org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.VRDR.model.util.CommonUtil;
import edu.gatech.VRDR.model.util.DeathCertificateReferenceUtil;

@ResourceDef(name = "DocumentReference", profile = "http://hl7.org/fhir/us/vrdr/StructureDefinition/VRDR-Death-Certificate-Reference")
public class DeathCertificateReference extends DocumentReference {
	public DeathCertificateReference() {
		super();
		CommonUtil.initResource(this);
	}
	public DeathCertificateReference(DocumentReferenceStatus status) {
		this();
		setStatus(status);
		setType(DeathCertificateReferenceUtil.type);
	}
	
	public void addDeathCertificateURL(String urlString) {
		DocumentReferenceContentComponent drcc = new DocumentReferenceContentComponent();
		Attachment attachment = new Attachment();
		attachment.setUrl(urlString);
		drcc.setAttachment(attachment);
		this.addContent(drcc);
	}
}