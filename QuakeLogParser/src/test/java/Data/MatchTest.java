package Data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MatchTest extends TestCase 
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatchTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatchTest.class );
    }
    
    /**
     * Teste apenas com a data de início
     */
    public void test_NullStartTime_ReturnsNull()
    {  	
    	//Act
    	Match match = new Match(null);
    	
    	//Assert
        assertNull(match.getStartTime());
        assertNull(match.getEndTime());
    }

    /**
     * Teste apenas com a data de início
     */
    public void test_WithoutEndTime_ReturnsNull()
    {
    	//Arrange
    	String expectedStart = "start"; 
    	
    	//Act
    	Match match = new Match(expectedStart);
    	
    	//Assert
        assertEquals(expectedStart, match.getStartTime());
        assertNull(match.getEndTime());
    }
    
    /**
     * Teste com data início e fim
     */
    public void test_WithEndTime_ReturnsEndTime()
    {
    	//Arrange
    	String expectedStart = "start"; 
    	String expectedEnd = "end"; 
    	Match match = new Match(expectedStart);
    	
    	//Act
    	match.setEndTime(expectedEnd);
    	
    	//Assert
        assertEquals(expectedStart, match.getStartTime());
        assertEquals(expectedEnd, match.getEndTime());
    }
}