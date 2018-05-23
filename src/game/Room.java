package game;

public class Room {
	
	private Room forward = null;
	private Room backward = null;
	private Room left = null;
	private Room right = null;
	private Room up = null; //these are going to go unused for now because I want to develop the 2-D aspect first
	private Room down = null;
	
	private boolean isFound;

	private int num_of_doors;
	
	//private List<Monster> monsters;
	//private List<game.Item> items;

	/**
	 *Creates a new game.Room that is either an Entrance or and Exit in the game.Dungeon. An Entrance only has one door at the
	 * back and does not have a chance for monsters or loot. The Exit will also only have one door, but it can be
	 * any of the walls.
	 * @param special_type The type of special room. This can either be "entrance" or "exit"
	 */
	public Room(String special_type){
		//handle being either an entrance or an exit
		if(special_type.equals("entrance")){
			this.num_of_doors = 1;
			//TODO
		}
		else if(special_type.equals("exit")){
			this.num_of_doors = 1;
			//TODO
		}
		else{
			throw new IllegalArgumentException("Error: special_type must be entrance or exit");
		}
	}

	public Room(Room comingFrom, String throughWhichDoor) {
		isFound = false;
		num_of_doors = 1;
		//monsters = new ArrayList<Monster>();
		//items = new ArrayList<game.Item>();

		if (throughWhichDoor.equals("left") || throughWhichDoor.equals("Left")) {
			this.right = comingFrom;
			this.right.left = this;

		} else if (throughWhichDoor.equals("right") || throughWhichDoor.equals("Right")) {
			this.left = comingFrom;
			this.left.right = this;

		} else if (throughWhichDoor.equals("forward") || throughWhichDoor.equals("Forward")) {
			this.backward = comingFrom;
			this.backward.forward = this;

		} else if (throughWhichDoor.equals("backward") || throughWhichDoor.equals("Backward")) {
			this.forward = comingFrom;
			this.forward.backward = this;

		} else {
			throw new IllegalArgumentException(throughWhichDoor + " is not a valid argument!");
		}
	}

	public Room getForward() {
		return forward;
	}

	public Room getBackward() {
		return backward;
	}

	public Room getLeft() {
		return left;
	}

	public Room getRight() {
		return right;
	}

	public boolean isFound() {
		return isFound;
	}
	
}