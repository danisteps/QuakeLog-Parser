package Business;

import Data.PlayerMatch;

public class LogUtils {
	private static String worldTag = "<world>";
	
	public static void ResolveKill(PlayerMatch match,  String killer, String deadPlayer, String mean){
		if (killer.equals(worldTag) || killer.equals(deadPlayer))
			match.addDeath(deadPlayer, mean);
		else
			match.addKill(killer, mean); 
	}
}
