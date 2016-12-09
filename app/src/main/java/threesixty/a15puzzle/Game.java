package threesixty.a15puzzle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import static threesixty.a15puzzle.R.id.statusmsg;

public class Game extends AppCompatActivity {
    // read this:
    // https://developer.android.com/guide/topics/ui/layout/gridview.html

    // the game board
    private BoardDrawable gb;
    private Board boardstate = new Board();

    //private ArrayList<Integer> validMoves;
    private char[] validMoves;

    public void setSolution(ArrayList<Board> states) {
        TextView statusmsg = (TextView)findViewById(R.id.statusmsg);
        statusmsg.setText("solved!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gb = new BoardDrawable(this);
        //get tha grid view
        GridView gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(gb);
        gb.setBoard(boardstate);

        Button solvebtn = (Button)findViewById(R.id.solve);
        final TextView statusmsg = (TextView)findViewById(R.id.statusmsg);


        final ArrayList<Board> b = new ArrayList<>();
        b.add(boardstate);

        solvebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                statusmsg.setText("solving...");
                ArrayList<Board> solution = new ArrayList<Board>();
                new Thread(new SolveThread(Game.this, boardstate)).start();

                //send boardstates to animation activity
                Intent animation = new Intent(Game.this,Animation.class);
                animation.putExtra("b",b);
                startActivity(animation);
            }
        });


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


            }
        });





    }
}
