package threesixty.a15puzzle;

import android.util.Log;

import java.lang.Runnable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by jake on 12/8/16.
 */

public class SolveThread implements Runnable {
    Board board;
    Game game;
    SolveThread(Game g, Board b) {
        game = g;
        board = b;
    }

    private ArrayList<Board> solveBoard(Board start) {
        PriorityQueue<Board> openset = new PriorityQueue<>();
        HashSet<Board> closedset = new HashSet<>();
        HashMap<Board, Board> camefrom = new HashMap<>();


        openset.add(start);
        //gscore.put(start, 0);


        while (!openset.isEmpty()) {
            Board current = openset.peek();
            Log.d("a* current", current.toString());
            openset.remove(current);
            closedset.add(current);

            /*if (!current.isSolvable()) {
                continue;
            }*/

            Log.d("solved", ""+ current.isSolved());
            if (current.isSolved()) {
                ArrayList<Board> result = new ArrayList<>();
                result.add(current);
                while (camefrom.containsKey(current)) {
                    current = camefrom.get(current);
                    result.add(current);
                }

                return result;
            }

            Log.d("moves", ""+ current.getMoves().length);
            for(char move : current.getMoves()) {
                Board neighbor = current.move(move);
                if (closedset.contains(neighbor)) {
                    continue;
                }

                Log.d("contains", ""+ openset.contains(neighbor));
                if (!openset.contains(neighbor)) {
                    openset.add(neighbor);
                }

                camefrom.put(neighbor, current);
            }
        }

        return null;
    }

    @Override
    public void run() {
        ArrayList<Board> steps = solveBoard(board);
        for(Board b: steps) {
            Log.d("board", b.toString());
        }

    }

}
