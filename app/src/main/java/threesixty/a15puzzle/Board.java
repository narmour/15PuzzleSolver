package threesixty.a15puzzle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.*;

import static android.R.attr.id;
import static android.R.attr.value;
import static android.R.attr.y;
import static android.R.id.empty;

public class Board implements Comparable<Board> {
    private char[] state = new char[16];

    Board() {
        for(char i = 1; i < 16; i++) {
            state[i-1] = i;
        }
        state[15] = 0;
    }

    Board(char[] board) {
        state = board;
    }

    Board move(char id) {
        char[] newstate = state.clone();
        if (id+1 < 16 && state[id+1] == 0) {
            newstate[id+1] = newstate[id];
            newstate[id] = 0;
        }
        else if (id-1 >= 0 && state[id-1] == 0) {
            newstate[id-1] = newstate[id];
            newstate[id] = 0;
        }
        else if (id+4 < 16 && state[id+4] == 0) {
            newstate[id+4] = newstate[id];
            newstate[id] = 0;
        }
        else if (id-4 >= 0 && state[id-4] == 0) {
            newstate[id-4] = newstate[id];
            newstate[id] = 0;
        }
        else {
            return null;
        }
        return new Board(newstate);
    }

    private char findEmpty() {
        for(char i = 0; i < 16; i++) {
            if (state[i] == 0) {
                return i;
            }
        }
        return (char)-1; // should never happen!
    }

    char[] getMoves() {
        char empty = findEmpty();

        int size = 0;
        if (empty % 4 < 3) {
            size++;
        }
        if (empty % 4 > 0) {
            size++;
        }
        if (empty+4 < 16) {
            size++;
        }
        if (empty-4 >= 0) {
            size++;
        }

        Log.d("getmoves", "size: " + size);
        char[] moves = new char[size];

        int index = 0;
        if (empty % 4 < 3) {
            moves[index++] = (char)(empty+1);
            Log.d("getmoves", "move: " + (int)moves[index-1]);
        }
        if (empty % 4 > 0) {
            moves[index++] = (char)(empty-1);
            Log.d("getmoves", "move: " + (int)moves[index-1]);
        }
        if (empty+4 < 16) {
            moves[index++] = (char)(empty+4);
            Log.d("getmoves", "move: " + (int)moves[index-1]);
        }
        if (empty-4 >= 0) {
            moves[index++] = (char)(empty-4);
            Log.d("getmoves", "move: " + (int)moves[index-1]);
        }

        return moves;
    }

    // read this : http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
    boolean isSolvable() {
        int inversions = 0;
        for(int i =0; i < 16;i++) {
            for (int j = i + 1; j < 16; j++)
                if (state[i] != 0 && state[j] != 0 && state[i] > state[j]){
                    Log.d("debug","i: " + state[i] + "j: " + state[j]);
                    inversions++;

                }
        }

        Log.d("solve","Inversions: " + inversions);
        int blankrow = findEmpty()/4;
        // if blank is on even row and inversiosn is odd, return true
        if(blankrow %2 ==0 && inversions %2 ==1)
            return true;
            // if blank is on odd row and inversions is even, return true
        else if(blankrow%2 ==1 && inversions%2 ==0)
            return true;

        return false;
    }

    public boolean isSolved() {
        return hamming() == 0;
    }

    // returns number of tiles in the wrong position
    int hamming() {
        int n = 0;
        for(int i = 0;i < 16;i++){
            if (state[i] == 0) {
                continue;
            }
            if (i+1 != state[i]) {
                n++;
            }
        }
        //Log.d("ham", "hamming: " + n);
        return n;
    }

    char at(int i) {
        return state[i];
    }


    public int compareTo(Board other) {
        return hamming() - other.hamming();
        //return other.hamming() - hamming();
    }


    public String toString() {
        return String.format(Locale.ENGLISH, "B[%2d %2d %2d %2d\n  %2d %2d %2d %2d\n  %2d %2d %2d %2d\n  %2d %2d %2d %2d]",
                (int)state[0], (int)state[1], (int)state[2], (int)state[3],
                (int)state[4], (int)state[5], (int)state[6], (int)state[7],
                (int)state[8], (int)state[9], (int)state[10], (int)state[11],
                (int)state[12], (int)state[13], (int)state[14], (int)state[15]);
    }

}
