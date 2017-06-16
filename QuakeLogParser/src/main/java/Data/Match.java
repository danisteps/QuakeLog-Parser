package Data;

import java.util.Date;

public class Match {
	private String start;
	private String end;
	
	public Match(String start){
		this.start = start;
	}
	
	public String getStartTime(){
		return start;
	}
	
	public String getEndTime(){
		return end;
	}
	
	public void setEndTime(String end){
		this.end = end;
	}
}