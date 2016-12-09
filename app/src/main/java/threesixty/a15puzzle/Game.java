package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    // read this:
    // https://developer.android.com/guide/topics/ui/layout/gridview.html

    // the game board
    private BoardDrawable gb;
    private Board boardstate = new Board();

    //private ArrayList<Integer> validMoves;
    private char[] validMoves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gb = new BoardDrawable(this);
        //get tha grid view
        GridView gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(gb);
        gb.setBoard(boardstate);

        // get valid moves
        /*validMoves =gb.getMoves();
        Log.d("debug",Integer.toString(validMoves.get(0)));
        Log.d("debug", "BLANK INDEX: " + gb.blankIndex);*/







        //set grid onclick listeners
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Log.d("debug", "asdasda " + validMoves.contains(position));
                /*if(validMoves.contains(position)){
                    boardstate.move(position);
                    //Log.d("solveable", "" + gb.isSolvable());

                    validMoves = boardstate.getMoves();
                }*/
                Board newstate = boardstate.move((char)position);
                if (newstate != null) {
                    boardstate = newstate;
                }
                gb.setBoard(boardstate);
                gb.notifyDataSetChanged();


            }
        });





    }
}
