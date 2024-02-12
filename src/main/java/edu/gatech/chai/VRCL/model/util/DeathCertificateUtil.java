package edu.gatech.chai.VRCL.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Composition.CompositionStatus;

import edu.gatech.chai.USCore.model.util.CommonUtil;
import edu.gatech.chai.VRCL.model.ActivityAtTimeOfDeath;
import edu.gatech.chai.VRCL.model.AutomatedUnderlyingCauseOfDeath;
import edu.gatech.chai.VRCL.model.AutopsyPerformedIndicator;
import edu.gatech.chai.VRCL.model.BirthRecordIdentifier;
import edu.gatech.chai.VRCL.model.CauseOfDeathPart1;
import edu.gatech.chai.VRCL.model.CauseOfDeathPart2;
import edu.gatech.chai.VRCL.model.Certifier;
import edu.gatech.chai.VRCL.model.CodedRaceAndEthnicity;
import edu.gatech.chai.VRCL.model.CodingStatusValues;
import edu.gatech.chai.VRCL.model.DeathCertificationProcedure;
import edu.gatech.chai.VRCL.model.DeathDate;
import edu.gatech.chai.VRCL.model.DeathLocation;
import edu.gatech.chai.VRCL.model.Decedent;
import edu.gatech.chai.VRCL.model.DecedentAge;
import edu.gatech.chai.VRCL.model.DecedentDispositionMethod;
import edu.gatech.chai.VRCL.model.DecedentEducationLevel;
import edu.gatech.chai.VRCL.model.DecedentFather;
import edu.gatech.chai.VRCL.model.DecedentMilitaryService;
import edu.gatech.chai.VRCL.model.DecedentMother;
import edu.gatech.chai.VRCL.model.DecedentPregnancyStatus;
import edu.gatech.chai.VRCL.model.DecedentSpouse;
import edu.gatech.chai.VRCL.model.DecedentUsualWork;
import edu.gatech.chai.VRCL.model.DispositionLocation;
import edu.gatech.chai.VRCL.model.EmergingIssues;
import edu.gatech.chai.VRCL.model.EntityAxisCauseOfDeath;
import edu.gatech.chai.VRCL.model.ExaminerContacted;
import edu.gatech.chai.VRCL.model.FuneralHome;
import edu.gatech.chai.VRCL.model.InjuryIncident;
import edu.gatech.chai.VRCL.model.InjuryLocation;
import edu.gatech.chai.VRCL.model.InputRaceAndEthnicity;
import edu.gatech.chai.VRCL.model.MannerOfDeath;
import edu.gatech.chai.VRCL.model.PlaceOfInjury;
import edu.gatech.chai.VRCL.model.RecordAxisCauseOfDeath;
import edu.gatech.chai.VRCL.model.SurgeryDate;
import edu.gatech.chai.VRCL.model.TobaccoUseContributedToDeath;

public class DeathCertificateUtil {
	public static final CompositionStatus status = CompositionStatus.FINAL;  
	public static final String title = "Death Certificate";
	public static final CodeableConcept typeFixedValue = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.loincSystemUrl,"64297-5","Death certificate"));
	public static final Composition.CompositionAttestationMode attesterMode = Composition.CompositionAttestationMode.LEGAL;
	public static final CodeableConcept eventCodeFixedValue = new CodeableConcept()
			.addCoding(new Coding(CommonUtil.snomedSystemUrl,"103693007","Diagnostic procedure (procedure)"));
	public static final String vrdrDocumentSectionUrl = "http://hl7.org/fhir/us/vrdr/CodeSystem/vrdr-document-section-cs";
	public static final CodeableConcept decendentDemographicsSectionCode = new CodeableConcept()
			.addCoding(new Coding(vrdrDocumentSectionUrl,"DecedentDemographics",""));
	public static final CodeableConcept deathInvestigationSectionCode = new CodeableConcept()
			.addCoding(new Coding(vrdrDocumentSectionUrl,"DeathInvestigation",""));
	public static final CodeableConcept deathCertificationSectionCode = new CodeableConcept()
			.addCoding(new Coding(vrdrDocumentSectionUrl,"DeathCertification",""));
	public static final CodeableConcept decedentDispositionSectionCode = new CodeableConcept()
			.addCoding(new Coding(vrdrDocumentSectionUrl,"DecedentDisposition",""));
	public static final CodeableConcept codedContentSectionCode = new CodeableConcept()
			.addCoding(new Coding(vrdrDocumentSectionUrl,"CodedContent",""));
	
	public static final Class[] decedentDemographicResources = {Decedent.class, DecedentFather.class, DecedentMother.class,
			DecedentSpouse.class, DecedentAge.class, BirthRecordIdentifier.class, DecedentEducationLevel.class,
			DecedentMilitaryService.class, DecedentUsualWork.class, EmergingIssues.class, InputRaceAndEthnicity.class};
	public static final Class[] deathInvestigationResources = {ExaminerContacted.class, DecedentPregnancyStatus.class,
			TobaccoUseContributedToDeath.class,PlaceOfInjury.class, InjuryLocation.class, InjuryIncident.class, AutopsyPerformedIndicator.class,
			DeathDate.class, DeathLocation.class, SurgeryDate.class};
	public static final Class[] deathCertificationResources = {Certifier.class, DeathCertificationProcedure.class,
			MannerOfDeath.class,CauseOfDeathPart1.class, CauseOfDeathPart2.class};
	public static final Class[] decedentDispositionResources = {DispositionLocation.class, FuneralHome.class,
			DecedentDispositionMethod.class};
	public static final Class[] codedContentResources = {ActivityAtTimeOfDeath.class, AutomatedUnderlyingCauseOfDeath.class,
			CodedRaceAndEthnicity.class,EntityAxisCauseOfDeath.class,RecordAxisCauseOfDeath.class,PlaceOfInjury.class,
			CodingStatusValues.class};
	
	public static final String filingFormatExtensionUrl = "http://hl7.org/fhir/us/vrdr/StructureDefinition/FilingFormat";
	public static final String filingFormatExtensionCodeSystem = "http://hl7.org/fhir/us/vrdr/CodeSystem/vrdr-filing-format-cs";
	public static final CodeableConcept electronicFilingFormat = new CodeableConcept()
			.addCoding(new Coding().setSystem(filingFormatExtensionCodeSystem).setCode("electronic").setDisplay("Electronic"));
	public static final CodeableConcept mixedFilingFormat = new CodeableConcept()
			.addCoding(new Coding().setSystem(filingFormatExtensionCodeSystem).setCode("mixed").setDisplay("Mixed"));
	public static final CodeableConcept paperFilingFormat = new CodeableConcept()
			.addCoding(new Coding().setSystem(filingFormatExtensionCodeSystem).setCode("paper").setDisplay("Paper"));
}