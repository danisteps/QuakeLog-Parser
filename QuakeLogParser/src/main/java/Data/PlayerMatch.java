package Data;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayerMatch {
	private Match matchInformation;
	private Map<Player, Kill> playerInformation;
	private List<Player> players;
	
	public PlayerMatch(String startTime){
		this.matchInformation = new Match(startTime);
		this.playerInformation = new HashMap<Player,Kill>();
	}
	
	public void addPlayer(String playerName){	
		if (playerName != null)
		{	
			Player player = new Player(playerName);
			if (this.players == null)
				players = new ArrayList<Player>();
			
			if (!playerInformation.containsKey(player))
			{
				players.add(player);
				playerInformation.put(player, new Kill());
			}
		}
	}
	
	public Match getMatchInformation(){
		return this.matchInformation;
	}
	
	public Kill getPlayerKill (String playerName){
		Player player = new Player(playerName);
		return this.playerInformation.get(player);
	}
	
	public void addKill(String killer, String mean){
		Player player = new Player(killer);
		playerInformation.get(player).addKill(mean);
	}
	
	public void addDeath(String deadPlayer, String mean){
		Player player = new Player(deadPlayer);
		playerInformation.get(player).addDeath(mean);
	}
}