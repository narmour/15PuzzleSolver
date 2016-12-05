package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //get tha grid view
        GridView gridView = (GridView)findViewById(R.id.grid);
        gridView.setAdapter(new ImageAdapter(this));

        //set grid onclick listeners
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Game.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });





    }
}
