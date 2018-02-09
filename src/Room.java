import java.util.List;

public class Room {
	
	private Room forward;
	private Room backward;
	private Room left;
	private Room right;
	private Room up; //these are going to go unused for now because I want to develop the 2-D aspect first
	private Room down;
	
	private boolean isFound;
	
	//private List<Monster> monsters;
	//private List<Item> items;

	public Room() {
		isFound = false;
		//monsters = new ArrayList<Monster>();
		//items = new ArrayList<Item>();
	}

}