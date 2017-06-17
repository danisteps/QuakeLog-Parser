package Business;
import java.text.ParseException;
import java.util.List;

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
	
	public GamePresentation getAllMatches(){
		GamePresentation present = new GamePresentation();
		
		//Recupera todas as partidas
		List<PlayerMatch> matches = repository.getAll();
		
		//Contrói o presentation da tela
		present.build(matches);
		
		return present;
	}
}