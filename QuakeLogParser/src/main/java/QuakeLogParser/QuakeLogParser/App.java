package QuakeLogParser.QuakeLogParser;
import java.text.ParseException;
import Business.LogParser;

public class App 
{
    public static void main( String[] args )
    {
    	LogParser parser = new LogParser();
        try 
        {
			parser.Parse("/Users/danielesoarespassos/Documents/eclipse_workspace/QuakeLog/src/Console/game.txt");
		} 
        catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}