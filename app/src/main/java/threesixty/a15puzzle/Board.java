package threesixty.a15puzzle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.*;
public class Board extends BaseAdapter{

    //ADAPTER STUFF
    private Context mContext;
    // references to our images
    private ArrayList<Tile> brd;

    int blankIndex;




    //constructor, takes in context for base adapter
    Board(Context c){
        //base adapter
        mContext = c;

        brd = new ArrayList<Tile>(Arrays.asList(new Tile(1,R.drawable.b_1),
                new Tile(2,R.drawable.b_2),new Tile(3,R.drawable.b_3),new Tile(4,R.drawable.b_4), new Tile(5,R.drawable.b_5),
                new Tile(6,R.drawable.b_6), new Tile(7,R.drawable.b_7), new Tile(8,R.drawable.b_8), new Tile(9,R.drawable.b_9),
                new Tile(10,R.drawable.b_10),new Tile(11,R.drawable.b_11), new Tile(12,R.drawable.b_12), new Tile(13,R.drawable.b_13),
                new Tile(14,R.drawable.b_14), new Tile(15,R.drawable.b_15),new Tile(0,R.drawable.b_0)));

        blankIndex =15;
    }


    //i = idx of blank
    //j = idx of tile to move into blank
    void move(int i, int j){
        Collections.swap(brd,i,j);
        blankIndex = j;

        notifyDataSetChanged();

    }

    boolean isDone(){
        return false;

    }

    // read this : http://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
    boolean isSolvable(){
        int inversions = 0;
        for(int i =0; i < 16;i++) {
            for (int j = i + 1; j < 16; j++)
                if (i != blankIndex && j!=blankIndex && brd.get(i).value > brd.get(j).value){
                    Log.d("debug","i: " + brd.get(i).value + "j: " + brd.get(j).value);
                    inversions++;

                }
        }

        Log.d("solve","Inversions: " + inversions);
        int blankrow = blankIndex/4;
        // if blank is on even row and inversiosn is odd, return true
        if(blankrow %2 ==0 && inversions %2 ==1)
            return true;
        // if blank is on odd row and inversions is even, return true
        else if(blankrow%2 ==1 && inversions%2 ==0)
            return true;

        return false;
    }

    // returns number of tiles in the wrong position
    int hamming(){
        int n = 0;
        for(int i =0;i < 16;i++){
            if(i ==15)
                if(brd.get(i).value !=0)
                    n++;
            else if(brd.get(i).value !=(i +1))
            n++;

        }
        return n;


    }


    ArrayList<Integer> getMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        for(int i = 0; i < this.brd.size(); i++){
            if(i == blankIndex){
                if(i + 1 <= 16)
                    moves.add(i+1);
                if(i - 1 >= 0)
                    moves.add(i-1);
                if(i + 4 <= 16)
                    moves.add(i+4);
                if(i - 4 >= 0)
                    moves.add(i-4);
            }
        }
        return moves;
    }



    //BASE ADAPTER FUNCTIONS
    public int getCount() {
        return brd.size();
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
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(brd.get(position).imgResource);
        return imageView;
    }

     /*
    public static void main(String[] args){
        Board b = new Board();
        b.printBoard();
        b.printMoves();
        System.out.println();
        b.brd = b.move(0,1);
        b.printBoard();
        b.printMoves();
    }
    */
        
}
