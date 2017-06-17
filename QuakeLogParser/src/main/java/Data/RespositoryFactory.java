package Data;

public class RespositoryFactory {
	
	public static IRespository createPlayerMatchRepository (RespositoryType type){
		IRespository repository = null;
		
		switch(type){
		case Cache:
			repository = new  CacheMemoryRepository();
			break;
		}
		
		return repository;
	}
}