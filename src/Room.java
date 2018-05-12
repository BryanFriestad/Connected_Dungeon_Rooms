import java.util.List;

public class Room {
	
	private Room forward;
	private Room backward;
	private Room left;
	private Room right;
	private Room up; //these are going to go unused for now because I want to develop the 2-D aspect first
	private Room down;
	
	private boolean isFound;

	private int num_of_doors;
	
	//private List<Monster> monsters;
	//private List<Item> items;

	/**
	 *Creates a new Room that is either an Entrance or and Exit in the Dungeon. An Entrance only has one door at the
	 * back and does not have a chance for monsters or loot. The Exit will also only have one door, but it can be
	 * any of the walls.
	 * @param special_type The type of special room. This can either be "entrance" or "exit"
	 */
	public Room(String special_type){
		//handle being either an entrance or an exit
	}

	public Room(Room comingFrom, String throughWhichDoor) {
		isFound = false;
		//monsters = new ArrayList<Monster>();
		//items = new ArrayList<Item>();

		switch (throughWhichDoor){
			case "left":
			case "Left":
				this.right = comingFrom;
				this.right.left = this;
				break;

			case "right":
			case "Right":
				this.left = comingFrom;
				this.left.right = this;
				break;

			case "forward":
			case "Forward":
				this.backward = comingFrom;
				this.backward.forward = this;
				break;

			case "backward":
			case "Backward":
				this.forward = comingFrom;
				this.forward.backward = this;
				break;

			default:
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