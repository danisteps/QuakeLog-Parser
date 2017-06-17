package Business;
import java.text.ParseException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Business.LogParser;
import Data.IRespository;
import Data.PlayerMatch;
import Data.RespositoryFactory;
import Data.RespositoryType;

public class AppController 
{
	private IRespository repository;
	
	public AppController(){
		this.repository = RespositoryFactory.createPlayerMatchRepository(RespositoryType.Cache);
	}
	
	/*
	 * Importa as informações de um arquivo de log
	 */
	public void ImportLog(String filePath){
		
		LogParser parser = new LogParser();
		
        try 
        {
        	//Converte para o tipo conhecido
        	List<PlayerMatch> matches = parser.Parse(filePath);
        	
        	//Salva no repositório
        	repository.add(matches);
		} 
        catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Recupera todas as partidas em presentation
	 */
	public GamePresentation getAllMatches()
	{		
		//Recupera todas as partidas
		List<PlayerMatch> matches = repository.getAll();
		
		//Contrói o presentation da tela
		GamePresentation presentation = new GamePresentation();
		presentation.build(matches);
		
		return presentation;
	}
	
	/*
	 * Retorna todas as partidas em formato JSON
	 */
	public String getAllMatchesInJSON(){
		
		String jsonInString = "Nenhuma partida foi importada.";
		
		//Recuepra as partidas
		GamePresentation presentation = getAllMatches();
		
		List<MatchSummary> presentMatches = presentation.getMatches();
		ObjectMapper mapper = new ObjectMapper();
    	
    	try 
    	{
    		//Converte para json
    		if (presentMatches != null && presentMatches.size() > 1)
    			jsonInString = mapper.writeValueAsString(presentMatches);
		} 
    	catch (JsonProcessingException e)
    	{
			System.out.println("Erro!");
		}
		
		return jsonInString;
	}
}