package threesixty.a15puzzle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.*;

public class BoardDrawable extends BaseAdapter{

    //ADAPTER STUFF
    private Context mContext;
    // references to our images
    private ArrayList<Tile> tileImages;
    Board board;

    //constructor, takes in context for base adapter
    BoardDrawable(Context c){
        //base adapter
        mContext = c;

        tileImages = new ArrayList<Tile>(Arrays.asList(new Tile(0,R.drawable.b_0), new Tile(1, R.drawable.b_1),
                     new Tile(2,R.drawable.b_2),new Tile(3,R.drawable.b_3),new Tile(4,R.drawable.b_4), new Tile(5,R.drawable.b_5),
                     new Tile(6,R.drawable.b_6), new Tile(7,R.drawable.b_7), new Tile(8,R.drawable.b_8), new Tile(9,R.drawable.b_9),
                     new Tile(10,R.drawable.b_10),new Tile(11,R.drawable.b_11), new Tile(12,R.drawable.b_12), new Tile(13,R.drawable.b_13),
                     new Tile(14,R.drawable.b_14), new Tile(15,R.drawable.b_15)));
    }

    void setBoard(Board b) {
        board = b;
        notifyDataSetChanged();
    }


    //BASE ADAPTER FUNCTIONS
    public int getCount() {
        //return brd.size();
        return 16;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setPadding(0,0,0,0);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(tileImages.get(board.at(position)).imgResource);
        return imageView;
    }
}
