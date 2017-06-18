package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Data.PlayerMatch;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MatchSummaryTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MatchSummaryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MatchSummaryTest.class );
    }
    
    /**
     * Testa o sumário para partida vazia
     */
    public void test_NullMatch_ReturnsEmptySummary()
    {  	
    	//Arrange
    	MatchSummary summary = new MatchSummary();
    	
    	//Act
    	summary.build(null);
    	List<String> players = summary.getPlayers();
    	
    	//Assert
        assertEquals(0, players.size());
        assertEquals(0, summary.getTotal_kills());
    }
    
    /**
     * Testa o sumário para partida vazia
     */
    public void test_EmptyMatch_ReturnsEmptySummary()
    {  	
    	//Arrange
    	MatchSummary summary = new MatchSummary();
    	PlayerMatch match = new PlayerMatch("start");
    	
    	//Act
    	summary.build(match);
    	List<String> players = summary.getPlayers();
    	
    	//Assert
        assertEquals(0, players.size());
        assertEquals(0, summary.getTotal_kills());
    }
    
    /**
     * Testa o sumário para dois jogadores com mortes
     */
    public void test_TwoPlayersWithKillsAndDeaths_ReturnsSummary()
    {  	
    	//Arrange
    	MatchSummary summary = new MatchSummary();
    	PlayerMatch match = new PlayerMatch("start");
    	match.addPlayer("player1");
    	match.addPlayer("player2");
    	match.addKill("player1", "MOD_UNKNOWN");
    	match.addKill("player1", "MOD_UNKNOWN");
    	match.addDeath("player1", "MOD_UNKNOWN");
    	match.addDeath("player1", "MOD_UNKNOWN");
    	match.addKill("player2", "MOD_UNKNOWN");
    	
    	//Act
    	summary.build(match);
    	List<String> players = summary.getPlayers();
    	
    	//Assert
        assertEquals(2, players.size());
        assertEquals(5, summary.getTotal_kills());
    }
}
