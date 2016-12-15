package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        BoardGridAdapter boardgrid = new BoardGridAdapter(this);

        Log.d("Animation", "got here");
        //get arraylist of boards
        //ArrayList<Board> boards = (ArrayList<Board>)getIntent().getSerializableExtra("b");
        ArrayList<Board> boards = new ArrayList<>();
        boards.add(new Board());
        boards.add(new Board());
        boards.add(new Board());
        boards.add(new Board());
        boards.add(new Board());
        boards.add(new Board());


        // get tha grid view
        GridView gridView = (GridView)findViewById(R.id.animationgrid);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);
        boardgrid.setBoards(boards);


        gridView.setAdapter(boardgrid);
        //BoardDrawable bd = new BoardDrawable(this);
        //bd.setBoard(boards.get(0));
    }
}
