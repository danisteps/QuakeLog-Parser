package Business;

import java.util.ArrayList;
import java.util.List;

import Data.Kill;
import Data.Player;
import Data.PlayerMatch;

public class MatchSummary {
	
	private int total_kills;
	private List<String> players;
	private List<KillSumary> kills;
	
	public MatchSummary(){
		this.total_kills = 0;
		this.players = new ArrayList<String>();
		this.kills = new ArrayList<KillSumary>();
	}
	
	public void build (PlayerMatch match){
		if (match != null){
			
			//Recupera os jogadores da partida
			List<Player> playersList = match.getPlayers();
			
			//Dada uma partida, preenche as informações necessárias
			for (Player temp : playersList) {
				players.add(temp.getName());
				
				//Recupera as mortes do jogador
				Kill playerKill = match.getPlayerKill(temp.getName());
				
				//Adiciona um novo sumário de mortes para o jogador
				KillSumary killSummary = new KillSumary(temp.getName(), playerKill.getKillsAndConsiderDeaths());
				kills.add(killSummary);
				
				//Atualiza o número total de mortes na partida
				this.total_kills += playerKill.getTotalKills();
			}
		}
	}

	public int getTotal_kills() {
		return total_kills;
	}

	public void setTotal_kills(int total_kills) {
		this.total_kills = total_kills;
	}

	public List<String> getPlayers() {
		return players;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}

	public List<KillSumary> getKills() {
		return kills;
	}

	public void setKills(List<KillSumary> kills) {
		this.kills = kills;
	}
}