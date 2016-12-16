package threesixty.a15puzzle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animation extends AppCompatActivity {
    Thread sthread;

    public abstract class ThreadProgressRunnable implements Runnable {
        ArrayList<Board> boards;
        public void setBoards(ArrayList<Board> b) {
            boards = b;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);



        final BoardGridAdapter boardgrid = new BoardGridAdapter(this);

        Board boardstate = (Board)getIntent().getSerializableExtra("b");

        final Handler handler = new Handler();
        final ThreadProgressRunnable threadProgress = new ThreadProgressRunnable() {
            @Override
            public void run() {
                boardgrid.setBoards(boards);
                setTitle("solving, " + boards.size() + " moves");
            }
        };

        sthread = new Thread(new SolveThread(Animation.this, boardstate, handler, threadProgress));
        //sthread = new SolveThread(Animation.this, boardstate, handler, threadProgress);
        sthread.start();

        GridView gridView = (GridView)findViewById(R.id.animationgrid);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);
        gridView.setAdapter(boardgrid);
    }


    @Override
    public void onBackPressed() {
        sthread.interrupt();
        super.onBackPressed();
    }
}
