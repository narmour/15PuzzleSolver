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
import static android.R.id.empty;

public class Board {
    private char[] state = new char[16];

    Board() {
        for(char i = 0; i < 16; i++) {
            state[i] = i;
        }
    }

    Board(char[] board) {
        state = board;
    }

    Board move(char id) {
        if (id+1 < 16 && state[id+1] == 0) {
            state[id+1] = state[id];
            state[id] = 0;
        }
        else if (id-1 >= 0 && state[id-1] == 0) {
            state[id-1] = state[id];
            state[id] = 0;
        }
        else if (id+4 < 16 && state[id+4] == 0) {
            state[id+4] = state[id];
            state[id] = 0;
        }
        else if (id-4 >= 0 && state[id-4] == 0) {
            state[id-4] = state[id];
            state[id] = 0;
        }
        else {
            return null;
        }
    }


    char[] getMoves() {
        char empty = 0;
        for(char i = 0; i < 16; i++) {
            if (state[i] == 0) {
                empty = i;
                break;
            }
        }

        int size = 0;
        if (empty+1 < 16 && state[empty+1] == 0) {
            size++;
        }
        if (empty-1 >= 0 && state[empty-1] == 0) {
            size++;
        }
        if (empty+4 < 16 && state[empty+4] == 0) {
            size++;
        }
        if (empty-4 >= 0 && state[empty-4] == 0) {
            size++;
        }

        char[] moves = new char[size];

        int index = 0;
        if (empty+1 < 16 && state[empty+1] == 0) {
            moves[index++] = (char)(empty+1);
        }
        if (empty-1 >= 0 && state[empty-1] == 0) {
            moves[index++] = (char)(empty-1);
        }
        if (empty+4 < 16 && state[empty+4] == 0) {
            moves[index++] = (char)(empty+4);
        }
        if (empty-4 >= 0 && state[empty-4] == 0) {
            moves[index++] = (char)(empty-4);
        }

        return moves;
    }








}
