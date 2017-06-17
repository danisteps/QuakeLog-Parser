package Data;
import java.util.List;

public interface IRespository {
	
	void add (List<PlayerMatch> matches);
	
	List<PlayerMatch> getAll();
}