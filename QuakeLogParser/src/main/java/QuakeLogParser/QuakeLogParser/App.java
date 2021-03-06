package QuakeLogParser.QuakeLogParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Business.AppController;

public class App 
{
	private AppController controller;
	
	public App (){
		this.controller = new AppController();
	}
	
    public void run()
    {	
    	int key = 0;
    	System.out.println("Bem-vindo(a) ao console de leitura de Quake Logs.");
    	
    	while(key < 4){
    		System.out.println("O que deseja fazer:");
    		System.out.println("1 - Importar log de jogo");
    		System.out.println("2 - Listar todas as partidas");
    		System.out.println("3 - Listar ranking de jogadores");
    		System.out.println("4 - Sair");
    		System.out.println("Digite o número da operação.");
    		
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		
    		try
    		{
               key = Integer.parseInt(br.readLine());
               
               switch (key)
               {
               case 1:
            	   Import();
            	   break;
               case 2:
            	   ListMatches();
            	   break;
               case 3:
            	   ListRanking();
            	   break;
               case 4:
            	   break;
               default:
            	   System.out.println("Você digitou uma opção inválida. Tente novamente.");
            	   break;
               }
          
            }
    		catch(NumberFormatException nfe){
    			key = 0;
            	System.out.println("Você digitou uma opção inválida. Tente novamente.");
            }
    		catch (IOException e) {
    			System.out.println("Aconteceu um erro durante a execução. Será preciso fechar a aplicação.");
    			break;
			}
    	}
    }
    
    private void Import() throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String filePath = "";
    	
    	while (filePath == null || filePath.equals("")){    		
    		System.out.println("Entre o caminho do arquivo:");
    		filePath = br.readLine();
    	}
    	
    	String error = controller.TryImportLog(filePath);
    	
    	if (error != null)
    		System.out.println("Erro: " + error);
    }
    
    private void ListMatches(){
    	String matches = controller.getAllMatchesInJSON();
    	System.out.println(matches);
    }
    
    private void ListRanking(){
    	String ranking = controller.getAndSaveRankingInJSON();
    	System.out.println(ranking);
    }
}