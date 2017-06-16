package Data;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class KillTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KillTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KillTest.class );
    }
    
    /**
     * Teste de quantidade de mortes sem nenhuma morte
     */
    public void test_EmptyKillsAndDeaths_ReturnsZero()
    {  	
    	//Arrange
    	int expectedTotal = 0;
    	Kill kill = new Kill();
    	
    	//Act
    	int totalResult = kill.getTotalKills();
    	int considerDeathResult = kill.getKillsAndConsiderDeaths();
    	
    	//Assert
        assertEquals(expectedTotal, totalResult);
        assertEquals(expectedTotal, considerDeathResult);
    }
    
    /**
     * Teste de quantidade de mortes com uma morte
     */
    public void test_OnlyKills_ReturnsTotalKills()
    {  	
    	//Arrange
    	int expectedTotal = 1;
    	Kill kill = new Kill();
    	kill.addKill("MOD_BFG");
    	
    	//Act
    	int result = kill.getTotalKills();
    	int considerDeathResult = kill.getKillsAndConsiderDeaths();
    	
    	//Assert
        assertEquals(expectedTotal, result);
        assertEquals(expectedTotal, considerDeathResult);
    }
    
    public void test_OnlyDeaths_ReturnsTotalKills()
    {  	
    	//Arrange
    	int expectedTotal = 1;
    	Kill kill = new Kill();
    	kill.addDeath("MOD_BFG");
    	
    	//Act
    	int result = kill.getTotalKills();
    	int considerDeathResult = kill.getKillsAndConsiderDeaths();
    	
    	//Assert
        assertEquals(expectedTotal, result);
        assertEquals(-expectedTotal, considerDeathResult);
    }
    
    public void test_KillsAndDeaths_ReturnsTotalKills()
    {  	
    	//Arrange
    	int expectedTotal = 2;
    	Kill kill = new Kill();
    	kill.addKill("MOD_BFG");
    	kill.addDeath("MOD_BFG");
    	
    	//Act
    	int result = kill.getTotalKills();
    	int considerDeathResult = kill.getKillsAndConsiderDeaths();
    	
    	//Assert
        assertEquals(expectedTotal, result);
        assertEquals(0, considerDeathResult);
    }
}