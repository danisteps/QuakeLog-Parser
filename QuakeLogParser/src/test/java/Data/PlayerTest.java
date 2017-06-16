package Data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PlayerTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlayerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PlayerTest.class );
    }
    
    /**
     * Teste com nome nulo
     */
    public void test_NullName_ThrowsException() throws IllegalArgumentException
    {  	try{    	
	    	//Act
	    	Player player = new Player(null); 
	    	fail( "Missing exception" );
    	}
	    catch(IllegalArgumentException e){
	    	assertTrue(true);
	    }
    	
    }

    /**
     * Teste com nome válido
     */
    public void test_ValidName_ThrowsException()
    {  	
    	//Arrange
    	String expected = "name";
    	
    	//Act
    	Player player = new Player(expected);
    	
    	//Assert
        assertEquals(expected, player.getName());
    }
}