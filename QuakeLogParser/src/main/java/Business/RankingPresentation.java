package Business;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Data.Kill;
import Data.Player;
import Data.PlayerMatch;

public class RankingPresentation {
	private Map <String, Integer> sortedPlayers;
	
	public Map<String, Integer> getSortedPlayers() {
		return sortedPlayers;
	}

	public RankingPresentation(){
		this.sortedPlayers = new HashMap<String, Integer>();
	}
	
	public void build(List<PlayerMatch> matches){
		
		Map <String, Integer> players = new HashMap<String, Integer>();
		
		if (matches != null){
			for(PlayerMatch match : matches){
				Map<Player, Kill> playerInformation = match.getPlayerInformation();
				for(Map.Entry<Player,Kill> entry : playerInformation.entrySet())
				{
					Integer previousCount = players.get(entry.getKey().getName());
					
					if (previousCount == null)
						previousCount = 0;
					
					players.put(entry.getKey().getName(), previousCount + entry.getValue().getKillsAndConsiderDeaths());					
				}
			}
			
			sortedPlayers = sortMapByValue(players);
		}
	}
	
	public static <String, Integer extends Comparable<? super Integer>> Map<String, Integer> sortMapByValue( Map<String, Integer> map )
	{
	    List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>( map.entrySet() );
	    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	        {
	            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2)
	            {
	            	return (entry2.getValue()).compareTo(entry1.getValue());
	            }
	        } 
	    );
	
	    Map<String, Integer> result = new LinkedHashMap<String, Integer>();
	    for (Map.Entry<String, Integer> entry : list)
	        result.put( entry.getKey(), entry.getValue() );

	    return result;
	}
}