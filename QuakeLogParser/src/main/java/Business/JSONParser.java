package Business;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import Data.Log;
import Data.PlayerMatch;

public class JSONParser  implements IParser{

	@Override
	public List<PlayerMatch> Parse(String filePath, BufferedReader reader) throws ParseException {
		
		List<PlayerMatch> matches = new ArrayList<PlayerMatch>();		

		//Leitura e interpretação do log
	    
	    InputStream inputstream;
	    Gson gson = new Gson();
	    
        try {
               inputstream = new FileInputStream(filePath);
               JsonReader jsonReader = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
               PlayerMatch match = null;
               jsonReader.beginArray();
               
               while (jsonReader.hasNext()) 
               {
                   Log log = gson.fromJson(jsonReader, Log.class);
                   
                   if (log != null)
                   {
                	   String initPattern = "initgame";
                	   
                	   if (log.getEventName().equals(initPattern)){
                		   match = new PlayerMatch(log.getMeta().getTime());
                	   }
                	   else if (log.getEventName().equals("shutdowngame"))
                	   {
                		   matches.add(match);
                	   }
                	   else if (log.getEventName().equals("clientuserinfochanged")){
                		   match.addPlayer(log.getMeta().getUserName());
                	   }
                	   else if (log.getEventName().equals("kill")){
                		   LogUtils.ResolveKill(match, log.getMeta().getUser(), log.getMeta().getPlayer(), log.getMeta().getBy());
                	   }
                   }
               }
               
               jsonReader.endArray();
        }
        catch (IOException ex){
        	
        }
	  
		
		return matches;
	}

}
