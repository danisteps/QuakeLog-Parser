package Business;

import java.io.BufferedReader;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileValidatorTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FileValidatorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FileValidatorTest.class );
    }
    
    /**
     * Testa o leitor par arquivo inválido
     */
    public void test_InvalidFile_ReturnsError()
    {  	
    	//Arrange
    	FileValidator validator = new FileValidator();
    	
    	//Act
    	BufferedReader result = validator.validateAndOpen("teste");
    	
    	//Assert
    	assertNull(result);
    	assertNotNull(validator.getError());
    }
}