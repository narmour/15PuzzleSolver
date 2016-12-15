package threesixty.a15puzzle;

import android.os.Handler;
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
    Animation anim;
    Handler handler;
    Animation.ThreadProgressRunnable callback;
    SolveThread(Animation a, Board b, Handler h, Animation.ThreadProgressRunnable r) {
        anim = a;
        board = b;
        handler = h;
        callback = r;
    }

    private void notifyActivity(Board board, HashMap<Board, Board> camefrom) {
        ArrayList<Board> result = new ArrayList<>();
        result.add(board);
        while (camefrom.containsKey(board)) {
            board = camefrom.get(board);
            result.add(board);
        }

        callback.setBoards(result);
        handler.post(callback);
        //return result;
        //callback.setBoards(result);
        //callback.run();
    }


    private ArrayList<Board> solveBoard(Board start) {
        PriorityQueue<Board> openset = new PriorityQueue<>();
        HashSet<Board> closedset = new HashSet<>();
        HashMap<Board, Board> camefrom = new HashMap<>();


        openset.add(start);
        //gscore.put(start, 0);


        while (!openset.isEmpty() && !Thread.currentThread().isInterrupted()) {
            Board current = openset.peek();
            Log.d("a* current", current.toString());
            openset.remove(current);
            closedset.add(current);

            if (!current.isSolvable()) {
                continue;
            }

            notifyActivity(current, camefrom);

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

            // aaa

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

        return new ArrayList<Board>();
    }

    @Override
    public void run() {
        ArrayList<Board> steps = solveBoard(board);
        for(Board b: steps) {
            Log.d("board", b.toString());
        }

    }

}
