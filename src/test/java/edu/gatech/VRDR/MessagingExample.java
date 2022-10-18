package edu.gatech.VRDR;

import java.util.UUID;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleType;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.MessageHeader;
import org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent;
import org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.UriType;

import edu.gatech.chai.VRDR.model.DeathCertificateDocument;

/**
 * This is an example set of functions for creating VRDR Messaging standard, enchanced by the original library
 * http://build.fhir.org/ig/nightingaleproject/vital_records_fhir_messaging_ig/branches/main/index.html
 */
public class MessagingExample {
	//Example for creating a DeathReccordSubmissionMessage. Use to submit records to endpoint
	//http://build.fhir.org/ig/nightingaleproject/vital_records_fhir_messaging_ig/branches/main/StructureDefinition-VRM-DeathRecordSubmissionMessage.html
	public Bundle createDeathRecordSubmissionMessage() {
		Bundle deathRecordSubmissionMessage = new Bundle();
		//Required setup for DeathRecord
		deathRecordSubmissionMessage.getMeta().addProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-DeathRecordSubmissionMessage");
		//We are assigning a random UUID; however we encourage implementers to use a consistent ID scheme for their messages
		deathRecordSubmissionMessage.setId(new IdType(UUID.randomUUID().toString());
		deathRecordSubmissionMessage.setType(BundleType.MESSAGE);

		DeathCertificateDocument deathCertificateDocument = BuildDCD.buildExampleDeathCertificateDocument();

		//Custom Message Header is used called a "Submission Header"
		MessageHeader submissionHeader = new MessageHeader();
		//Required setup for SubmissionHeader
		submissionHeader.getMeta().addProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-SubmissionHeader");
		submissionHeader.setId(new IdType(UUID.randomUUID().toString());
		submissionHeader.setEvent(new UriType("http://nchs.cdc.gov/vrdr_submission"));
		//Add destination to the message header
		MessageDestinationComponent destination = new MessageDestinationComponent();
		//Where the message will be sumitted
		destination.setEndpoint("http://nchs.cdc.gov/vrdr_submission");
		submissionHeader.addDestination(destination);
		//Define the source. Should be local system url
		MessageSourceComponent source = new MessageSourceComponent();
		source.setEndpoint("https://mysource.com");
		submissionHeader.setSource(source);
		submissionHeader.addFocus(new Reference("Bundle/"+deathCertificateDocument.getId()));
		
		//MessageParameters. Commonly used across many messages. Note each parameter is optional
		Parameters messageParameters = new Parameters();
		messageParameters.getMeta().addProfile("http://cdc.gov/nchs/nvss/fhir/vital-records-messaging/StructureDefinition/VRM-MessageParameters");
		messageParameters.setId(new IdType(UUID.randomUUID().toString()));
		ParametersParameterComponent jurisdiction_id = new ParametersParameterComponent();
		jurisdiction_id.setName("jurisdiction_id");
		jurisdiction_id.setValue(new StringType("myState")); //Note: Invalid value. Must use a correct jurisdiction_id. Refer to http://hl7.org/fhir/us/vrdr/STU2/ValueSet-vrdr-jurisdiction-vs.html
		ParametersParameterComponent cert_no = new ParametersParameterComponent();
		cert_no.setName("cert_no");
		cert_no.setValue(new StringType("12345")); //The certificate number defined from the EDRS
		ParametersParameterComponent death_year = new ParametersParameterComponent();
		death_year.setName("death_year");
		death_year.setValue(new IntegerType(2019)); //Year the death occurred
		ParametersParameterComponent state_auxillary_id = new ParametersParameterComponent();
		death_year.setName("state_auxillary_id");
		death_year.setValue(new StringType("67890"));
		messageParameters.addParameter(jurisdiction_id);
		messageParameters.addParameter(cert_no);
		messageParameters.addParameter(death_year);
		messageParameters.addParameter(state_auxillary_id);

		//Assign the message header, message parameters, and death certificate document to the submission message. IN THIS ORDER.
		deathRecordSubmissionMessage.addEntry(new BundleEntryComponent().setResource(submissionHeader));
		deathRecordSubmissionMessage.addEntry(new BundleEntryComponent().setResource(messageParameters));
		deathRecordSubmissionMessage.addEntry(new BundleEntryComponent().setResource(deathCertificateDocument));

		return deathRecordSubmissionMessage;
	}
}
