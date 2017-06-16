package Data;

public class Player {
	
	private String name;
	
	public Player (String name){
		if (name == null)
			throw new IllegalArgumentException();
		
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Player) {
        	Player player = (Player)obj;
            return name.equals(player.name);
        }
        return false;
    }
	
	@Override
    public int hashCode() {
        return (name).hashCode();
    }
}