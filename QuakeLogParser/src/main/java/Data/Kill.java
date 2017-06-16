package Data;
import java.util.List;
import java.util.ArrayList;

public class Kill {
	private List<MeansOfDeath> kills;
	private List<MeansOfDeath> deathsByWorld;
	
	private static String worldTag = "<world>";
	
	public Kill(){
		this.kills = new ArrayList<MeansOfDeath>();
		this.deathsByWorld = new ArrayList<MeansOfDeath>();
	}
	
	public void addKill(String killer, String mean){
		if (killer != null){
			MeansOfDeath meanOfDeath = MeansOfDeath.valueOf(mean);
			if (killer.equals(worldTag))
				deathsByWorld.add(meanOfDeath);
			else
				kills.add(meanOfDeath);
		}
	}
	
	public void addKill(String mean){
		MeansOfDeath meanOfDeath = MeansOfDeath.valueOf(mean);
		this.kills.add(meanOfDeath);
	}
	
	public void addDeath(String mean){
		MeansOfDeath meanOfDeath = MeansOfDeath.valueOf(mean);
		this.deathsByWorld.add(meanOfDeath);
	}
	
	public int getTotalKills(){
		return this.kills.size() + this.deathsByWorld.size();
	}
	
	public int getKillsAndConsiderDeaths(){
		return this.kills.size() - this.deathsByWorld.size();
	}
}