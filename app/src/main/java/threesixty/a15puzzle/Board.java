package threesixty.a15puzzle;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by student on 12/1/16.
 */

public class Board {
    // the game board
    ArrayList<Tile> brd;


    //constructor fills up brd
    Board(){
        // init arraylist
        brd = new ArrayList<Tile>();

        // make tiles
        for(int i =0;i<16;i++)
            brd.add(new Tile(i));

    }

    // debug print
    void printBoard(){
        for(Tile t:brd)
            Log.d("printBoard",t.value + "   ");
    }

}
