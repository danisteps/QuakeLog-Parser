package Data;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CacheMemoryRepositoryTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CacheMemoryRepositoryTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CacheMemoryRepositoryTest.class );
    }
    
    /**
     * Teste para verificar se os dados são persistidos norepositório
     */
    public void test_AddData_ReturnsAddedData()
    {  	
    	//Arrange
    	PlayerMatch match = new PlayerMatch("start");
    	CacheMemoryRepository rep = new CacheMemoryRepository();
    	List<PlayerMatch> matches = new ArrayList<PlayerMatch>();
    	matches.add(match);
    	
    	//Act
    	rep.add(matches);
    	List<PlayerMatch> result = rep.getAll();
    	
    	//Assert
        assertEquals(matches, result);
    }
    
    /**
     * Teste para verificar se o repositório lida com null
     */
    public void test_AddNullData_ReturnsNull()
    {  	
    	//Arrange
    	CacheMemoryRepository rep = new CacheMemoryRepository();
    	
    	//Act
    	rep.add(null);
    	List<PlayerMatch> result = rep.getAll();
    	
    	//Assert
        assertEquals(0, result.size());
    }
}