package Business;

import Data.Match;
import Data.MatchTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KillSumaryTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KillSumaryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KillSumaryTest.class );
    }
    
    /**
     * Teste apenas com a data de início
     */
    public void test_NullName_ReturnsEmptySummary()
    {  	
    	//Act
    	KillSumary summary = new KillSumary(null, 0);
    	
    	//Assert
        assertNull(summary.getPlayerName());
        assertEquals(0, summary.getPlayerKills());
    }

    /**
     * Teste a mudança de nome e quantidade de mortes
     */
    public void test_ChangeNameAndKills_ReturnsCompleteSummary()
    {
    	//Arrange
    	String expected = "name";
    	KillSumary summary = new KillSumary(null, 0);
    	
    	//Act
    	summary.setPlayerKills(10);
    	summary.setPlayerName(expected);
    	
    	//Assert
    	assertEquals(expected, summary.getPlayerName());
        assertEquals(10, summary.getPlayerKills());
    }
}