package game;

public class Dungeon {

    Room entrance;
    Room exit;

    public Dungeon(String filename){
        // load the dungeon from a file @ filename
        entrance = new Room("entrance");
        exit =  new Room("exit");
        //TODO
    }

    /**
     * Creates a new random dungeon that allows you to define the total number of rooms as well
     * as the room spanning preference. Options for design preference allow you to make the dungeon
     * go deeper, wider, or more bunched up.
     * @param num_of_rooms The number of rooms in the dungeon, not including the entrance and exit.
     * @param design_pref The preference for dungeon expansion. 1 means completely random; 2 means preference
     *                    to a deeper dungeon(forward & backward); 3 means preference to a wider dunegon(left & right);
     *                    4 means a preference to a condensed and bunched up dungeon.
     *
     */
    public Dungeon(int num_of_rooms, int design_pref){
        if(num_of_rooms < 0){
            throw new IllegalArgumentException("number_of_rooms must not be negative.");
        }
        //if()
        entrance = new Room("entrance");
        exit =  new Room("exit");
    }
}
