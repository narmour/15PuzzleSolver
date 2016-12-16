package threesixty.a15puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Setup extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    PopupMenu popup;
    BoardDrawable gb = new BoardDrawable(this);
    Board b = new Board();

    private int pos;

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Log.d("onprepareoptions" , "yo");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setup, menu);
        for(int i =0;i<15;i++) {
            menu.add(String.format("%d", i));
        }

        return true;
    }


    @Override
    public boolean onMenuItemClick(MenuItem item){
        char[] c = b.getState();
        int clickedIdx = b.valueAt(Integer.parseInt((String)item.getTitle()));
        char temp = c[pos];

        c[pos] = c[clickedIdx];
        c[clickedIdx] = temp;

        b.setState(c);
        gb.setBoard(b);
        return true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);


        gb.setBoard(b);




        //get tha grid view
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(gb);
        //gridView.setStretchMode(GridVie);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);


        //set grid onclick listeners
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                popup = new PopupMenu(Setup.this,v);
                popup.setOnMenuItemClickListener(Setup.this);
                MenuInflater mi = popup.getMenuInflater();
                mi.inflate(R.menu.setup,popup.getMenu());
                popup.show();

                pos = position;
            }


        });
    }


    }

