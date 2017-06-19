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
	private Map <String, Integer> sortedPlayersByKills;
	private Map <String, Integer> sortedPlayersByDeaths;
	
	public Map<String, Integer> getSortedPlayersByKills() {
		return sortedPlayersByKills;
	}
	
	public Map<String, Integer> getSortedPlayersByDeaths() {
		return sortedPlayersByDeaths;
	}

	public RankingPresentation(){
		this.sortedPlayersByKills = new HashMap<String, Integer>();
		this.sortedPlayersByDeaths = new HashMap<String, Integer>();
	}
	
	public void build(List<PlayerMatch> matches){
		
		Map <String, Integer> playersByKIlls = new HashMap<String, Integer>();
		Map <String, Integer> playersByDeaths = new HashMap<String, Integer>();
		
		if (matches != null){
			for(PlayerMatch match : matches){
				Map<Player, Kill> playerInformation = match.getPlayerInformation();
				for(Map.Entry<Player,Kill> entry : playerInformation.entrySet())
				{
					Integer previousCountByKills = playersByKIlls.get(entry.getKey().getName());
					Integer previousCountByDeaths = playersByDeaths.get(entry.getKey().getName());
					
					if (previousCountByKills == null)
						previousCountByKills = 0;
					
					if (previousCountByDeaths == null)
						previousCountByDeaths = 0;
					
					playersByKIlls.put(entry.getKey().getName(), previousCountByKills + entry.getValue().getKillsAndConsiderDeaths());	
					playersByDeaths.put(entry.getKey().getName(), previousCountByDeaths + entry.getValue().getDeathsByWorld());
				}
			}
			
			sortedPlayersByKills = sortMapByValue(playersByKIlls);
			sortedPlayersByDeaths = sortMapByValue(playersByDeaths);
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