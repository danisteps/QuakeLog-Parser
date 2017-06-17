package Data;
import java.util.ArrayList;
import java.util.List;

public class CacheMemoryRepository implements IRespository {
	private List<PlayerMatch> allMatches;

	public CacheMemoryRepository(){
		this.allMatches = new ArrayList<PlayerMatch>();
	}

	@Override
	public void add(List<PlayerMatch> matches) {
		if (matches != null){
			allMatches.addAll(matches);
		}
	}

	@Override
	public List<PlayerMatch> getAll() {
		return allMatches;
	}	
}