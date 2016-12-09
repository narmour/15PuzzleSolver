package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        Log.d("Animation", "got here");
        //get arraylist of boards
        ArrayList<Board> boards = (ArrayList<Board>)getIntent().getSerializableExtra("b");


        // get tha grid view
        GridView gridView = (GridView)findViewById(R.id.grid);
        BoardDrawable bd = new BoardDrawable(this);
        bd.setBoard(boards.get(0));


        gridView.setAdapter(bd);
    }
}
