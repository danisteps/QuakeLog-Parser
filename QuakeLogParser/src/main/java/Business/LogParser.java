package Business;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Data.PlayerMatch;

public class LogParser {
	private static String worldTag = "<world>";
	
	public List<PlayerMatch> Parse(String filePath) throws ParseException{
		
		List<PlayerMatch> matches = new ArrayList<PlayerMatch>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))) 
		{
			//Leitura
		    String line = br.readLine();
		    PlayerMatch currentMatch = null;
		    
		    while (line != null) {
		    	
		    	String leftRemoved = line.replaceAll("^\\s+", "");
		    	String[] splited = leftRemoved.split(" ");
		    	
		    	if (splited.length > 1){
		    		if (splited[1].startsWith("InitGame")){
		    			currentMatch = new PlayerMatch(splited[0]);
		    			
		    			line = br.readLine();
		    			
		    			while (line != null) {
		    				leftRemoved = line.replaceAll("^\\s+", "");
		    		    	splited = leftRemoved.split(" ");
		    		    	
				    		if (splited[1].startsWith("ClientUserinfoChanged")){
				    			
				    			String pattern = "(\\d+:\\d+ ClientUserinfoChanged: \\d+ n\\\\)([\\w ]+)(\\\\t)";
				    			Pattern regex = Pattern.compile(pattern);
				    			Matcher m = regex.matcher(line);
				    			
				    			if (m.find( ))
				    				currentMatch.addPlayer(m.group(2));
				    			
				    			//String[] playerInfo = splited[3].split("\\\\");
				    			//currentMatch.addPlayer(playerInfo[1]);
				    		}
				    		else if (splited[1].startsWith("Kill")){
				    			
				    			String pattern = "(Kill: \\d+ \\d+ \\d+:) (.*) (killed) (.*) (by) (.*)";
				    			Pattern regex = Pattern.compile(pattern);
				    			Matcher m = regex.matcher(line);
				    			
				    			if (m.find( )){
					    			String killer = m.group(2); //splited[5];
					    			String mean = m.group(6);//splited[9];
					    			
					    			if (killer.equals(worldTag)){
					    				String deadPlayer = m.group(4);//splited[7];
					    				currentMatch.addDeath(deadPlayer, mean);
					    			}
					    			else
					    				currentMatch.addKill(killer, mean);  
				    			}
				    		}
				    		else if (splited[1].startsWith("ShutdownGame") || splited[1].contains("---")){
				    			currentMatch.getMatchInformation().setEndTime(splited[0]);
				    			matches.add(currentMatch);
				    			break;
				    		}
				    		
				    		line = br.readLine();
		    			}
		    		}
		    	}
		    	
		        line = br.readLine();
		    }
		    //String everything = sb.toString();
		   	    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//catch(Exception e){
			//System.out.println(e.getMessage());
		//}
		
		return matches;
	}
}