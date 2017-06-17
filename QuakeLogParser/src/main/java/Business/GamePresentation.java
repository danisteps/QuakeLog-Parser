package Business;

import java.util.ArrayList;
import java.util.List;

import Data.PlayerMatch;

public class GamePresentation {
	private List<MatchSummary> matches;
	
	public GamePresentation(){
		this.matches = new ArrayList<MatchSummary>();
	}
	
	public void build (List<PlayerMatch> playerMatches){
		if (playerMatches != null){
			
			//Constói o sumário de cada partida
			for(PlayerMatch temp : playerMatches){
				MatchSummary summary = new MatchSummary();
				summary.build(temp);
				this.matches.add(summary);
			}
		}
	}

	public List<MatchSummary> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchSummary> matches) {
		this.matches = matches;
	}
}