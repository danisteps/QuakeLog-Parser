package Business;

import Data.IRespository;
import Data.Match;
import Data.MatchTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

public class AppControllerTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppControllerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppControllerTest.class);
    }
    
    /**
     * Teste com reader nulo
     */
    public void test_NullReader_ReturnsError()
    {  	
    	//Arrange
    	String path = "teste";
    	IRespository repositoryMock = mock(IRespository.class);
    	IParser parserMock = mock (IParser.class);
    	IValidator validatorMock = mock(IValidator.class);
    	
    	try {
			when(parserMock.Parse(path, null)).thenReturn(null);
		} catch (ParseException e) {
			fail();
		}
    	
    	when(validatorMock.validateAndOpen(path)).thenReturn(null);
    	when(validatorMock.getError()).thenReturn("Erro");
    	AppController controller = new AppController(repositoryMock, parserMock, validatorMock);
    	
    	//Act
    	String result = controller.TryImportLog(path);
    	
    	//Asert
    	assertNotNull(result);
    }
    
    /**
     * Teste com reader nulo
     */
    public void test_MockReader_ReturnsError()
    {  	
    	//Arrange
    	String path = "teste";
    	FileReader fileReader = mock(FileReader.class);
    	BufferedReader resultReader = new BufferedReader(fileReader);
    	IRespository repositoryMock = mock(IRespository.class);
    	IParser parserMock = mock (IParser.class);
    	IValidator validatorMock = mock(IValidator.class);
    	
    	try {
			when(parserMock.Parse(path, null)).thenReturn(null);
		} catch (ParseException e) {
			fail();
		}
    	
    	when(validatorMock.validateAndOpen(path)).thenReturn(resultReader);
    	AppController controller = new AppController(repositoryMock, parserMock, validatorMock);
    	
    	//Act
    	String result = controller.TryImportLog(path);
    	
    	//Asert
    	assertNull(result);
    }
}