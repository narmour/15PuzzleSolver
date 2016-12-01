package threesixty.a15puzzle;

/**
 * Created by student on 12/1/16.
 */

public class Tile {
    // tile number
    int value;
    boolean blank;

    //constructor takes in value
    Tile(int v){
        value  = v;
        // if v ==0, its the blank tile
        blank = (v ==0) ? true:false;
    }


}
