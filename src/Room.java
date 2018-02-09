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
}