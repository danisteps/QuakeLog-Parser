package Business;

import java.io.BufferedReader;
import java.text.ParseException;
import java.util.List;

import Data.PlayerMatch;

public interface IParser {
	List<PlayerMatch> Parse(String filePath, BufferedReader reader) throws ParseException;
}