package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    // read this:
    // https://developer.android.com/guide/topics/ui/layout/gridview.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // get tha grid
        GridLayout gl = (GridLayout)findViewById(R.id.grid);

        //put some fuckin buttons on the grid
        /*
        for(int row = 0;row < 4;row++){
            for(int col=0;col<4;col++){
                Button b = new Button(this);
                gl.addView(b,row,col);
            }
        }
        */
    }
}
