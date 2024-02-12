package edu.gatech.VRDR;

import edu.gatech.chai.VRCL.validation.VRDRValidator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ValidationTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ValidationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ValidationTest.class );
    }

    /**
     * 
     */
    public void testValidation()
    {
    	VRDRValidator.testValidation();
    	VRDRValidator.testSampleBundle();
    	assertTrue( true );
    }
}
