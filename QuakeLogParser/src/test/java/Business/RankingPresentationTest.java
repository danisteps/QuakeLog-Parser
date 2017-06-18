package Business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Data.PlayerMatch;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RankingPresentationTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RankingPresentationTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RankingPresentationTest.class );
    }
    
    /**
     * Testa o ranking para dois jogadores com mortes
     */
    public void test_TwoPlayersWithKills_ReturnsRanking()
    {  	
    	//Arrange
    	PlayerMatch match = new PlayerMatch("start");
    	match.addPlayer("player1");
    	match.addPlayer("player2");
    	match.addKill("player1", "MOD_UNKNOWN");
    	match.addKill("player1", "MOD_UNKNOWN");
    	List<PlayerMatch> matches = new ArrayList<PlayerMatch>();
    	matches.add(match);
    	RankingPresentation present = new RankingPresentation();
    	
    	//Act
    	present.build(matches);
    	Map<String,Integer> result = present.getSortedPlayers();
    	
    	//Assert
        assertEquals("player1", result.entrySet().iterator().next().getKey());
    }
    
    /**
     * Testa o ranking para dois jogadores com mortes
     */
    public void test_TwoPlayersWithKillsAndDeaths_ReturnsRanking()
    {  	
    	//Arrange
    	PlayerMatch match = new PlayerMatch("start");
    	match.addPlayer("player1");
    	match.addPlayer("player2");
    	match.addKill("player1", "MOD_UNKNOWN");
    	match.addKill("player1", "MOD_UNKNOWN");
    	match.addDeath("player1", "MOD_UNKNOWN");
    	match.addDeath("player1", "MOD_UNKNOWN");
    	match.addKill("player2", "MOD_UNKNOWN");
    	List<PlayerMatch> matches = new ArrayList<PlayerMatch>();
    	matches.add(match);
    	RankingPresentation present = new RankingPresentation();
    	
    	//Act
    	present.build(matches);
    	Map<String,Integer> result = present.getSortedPlayers();
    	
    	//Assert
        assertEquals("player2", result.entrySet().iterator().next().getKey());
    }
}
