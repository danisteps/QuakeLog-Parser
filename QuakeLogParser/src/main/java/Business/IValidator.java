package Business;

import java.io.BufferedReader;

public interface IValidator {
	BufferedReader validateAndOpen(String filePath);
	String getError();
}