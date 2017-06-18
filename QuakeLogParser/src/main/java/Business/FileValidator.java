package Business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileValidator implements IValidator {
	
	private String error;
	
	public BufferedReader validateAndOpen(String filePath){
		
		BufferedReader br = null;
		
		try 
		{
			br = new BufferedReader(new FileReader(filePath));
		} 
		catch (FileNotFoundException e) {
			this.error = "O arquivo não foi encontrado.";
		}
		
		return br;
	}

	public String getError() {
		return error;
	}
}