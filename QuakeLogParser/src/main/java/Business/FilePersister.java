package Business;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FilePersister implements IOutputPersister{

	public void save(String output) {
		PrintWriter out;
		try 
		{
			out = new PrintWriter("output.json");
			out.println(output);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}