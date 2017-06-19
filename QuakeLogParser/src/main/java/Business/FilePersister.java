package Business;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FilePersister implements IOutputPersister{

	public void save(String fileName, String output) {
		PrintWriter out;
		try 
		{
			out = new PrintWriter(fileName + ".json");
			out.println(output);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}