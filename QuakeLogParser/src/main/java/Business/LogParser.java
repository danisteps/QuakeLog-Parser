package Business;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.PlayerMatch;

public class LogParser implements IParser {
	
	private static String worldTag = "<world>";
	private static String initGameTag = "InitGame";
	private static String clientUserinfoChangedTag = "ClientUserinfoChanged";
	private static String killTag = "Kill";
	private static String shutdownGameTag = "ShutdownGame";
	
	public List<PlayerMatch> Parse(String filePath, BufferedReader reader) throws ParseException{
		
		List<PlayerMatch> matches = new ArrayList<PlayerMatch>();		

		//Leitura e interpretação do log
	    String line;
	    
		try {		
			line = reader.readLine();
				
		    PlayerMatch currentMatch = null;
		    
		    while (line != null) {
		    	
		    	String leftRemoved = line.replaceAll("^\\s+", "");
		    	String[] splited = leftRemoved.split(" ");
		    	
		    	if (splited.length > 1){
		    		
		    		//Começa um novo jogo
		    		if (splited[1].startsWith(initGameTag)){
		    			currentMatch = new PlayerMatch(splited[0]);
		    			
		    			line = reader.readLine();
		    			
		    			while (line != null) {
		    				leftRemoved = line.replaceAll("^\\s+", "");
		    		    	splited = leftRemoved.split(" ");
		    		    	
		    		    	//Caso em que se adiciona um novo jogador
				    		if (splited[1].startsWith(clientUserinfoChangedTag)){
				    			
				    			String pattern = "(\\d+:\\d+ ClientUserinfoChanged: \\d+ n\\\\)([\\w ]+)(\\\\t)";
				    			Pattern regex = Pattern.compile(pattern);
				    			Matcher m = regex.matcher(line);
				    			
				    			if (m.find( ))
				    				currentMatch.addPlayer(m.group(2));
				    		}
				    		//Caso em que jogadores morrem
				    		else if (splited[1].startsWith(killTag)){
				    			
				    			String pattern = "(Kill: \\d+ \\d+ \\d+:) (.*) (killed) (.*) (by) (.*)";
				    			Pattern regex = Pattern.compile(pattern);
				    			Matcher m = regex.matcher(line);
				    			
				    			if (m.find( )){
					    			String killer = m.group(2);
					    			String mean = m.group(6);
					    			String deadPlayer = m.group(4);
					    			
					    			if (killer.equals(worldTag) || killer.equals(deadPlayer))
					    				currentMatch.addDeath(deadPlayer, mean);
					    			else
					    				currentMatch.addKill(killer, mean);  
				    			}
				    		}
				    		//Caso que o jogo acaba
				    		else if (splited[1].startsWith(shutdownGameTag) || line.contains("-----")){
				    			currentMatch.getMatchInformation().setEndTime(splited[0]);
				    			matches.add(currentMatch);
				    			break;
				    		}
				    		
				    		line = reader.readLine();
		    			}
		    		}
		    	}
		    	
		        line = reader.readLine();
		    }
	    } 
		catch (IOException e) {
			throw new ParseException("", 0);
		}
		
		return matches;
	}
}