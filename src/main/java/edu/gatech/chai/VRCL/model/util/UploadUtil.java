package edu.gatech.chai.VRCL.model.util;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import ca.uhn.fhir.context.FhirContext;
import edu.gatech.chai.VRCL.context.VRDRFhirContext;
import edu.gatech.chai.VRCL.messaging.BaseMessage;
import edu.gatech.chai.VRCL.model.util.BuildDCD;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UploadUtil {

    /// <summary>Create the payload for submission to the NVSS FHIR API for bulk upload</summary>
    public static String CreateBulkUploadPayload(VRDRFhirContext ctx, List<BaseMessage> messages, String url, boolean prettyPrint)
    {
        Bundle payload = new Bundle();
        payload.setId(UUID.randomUUID().toString());
        payload.setType(Bundle.BundleType.BATCH);
        payload.setTimestamp(Date.from(Instant.now()));

        for (BaseMessage message : messages)
        {
            Bundle.BundleEntryComponent entry = new Bundle.BundleEntryComponent();
            entry.setResource(message);
            Bundle.BundleEntryRequestComponent request = new Bundle.BundleEntryRequestComponent(); //entry.getRequest();
            request.setMethod(Bundle.HTTPVerb.POST);
            request.setUrl(url);
            entry.setRequest(request);
            payload.getEntry().add(entry);
        }
        return ctx.getCtx().newJsonParser().setPrettyPrint(prettyPrint).encodeResourceToString(payload);
    }
}
