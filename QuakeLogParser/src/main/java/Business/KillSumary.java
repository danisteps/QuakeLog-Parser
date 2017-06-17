package Business;

public class KillSumary {
	
	private String playerName;
	private int playerKills;
	
	public KillSumary(String name, int kills){
		this.playerKills = kills;
		this.playerName = name;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getPlayerKills() {
		return playerKills;
	}
	public void setPlayerKills(int playerKills) {
		this.playerKills = playerKills;
	}
}