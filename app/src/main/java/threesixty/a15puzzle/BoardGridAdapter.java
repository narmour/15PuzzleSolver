package threesixty.a15puzzle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by student on 12/15/16.
 */

public class BoardGridAdapter extends BaseAdapter {
    //final int BITMAPSIZE = 500*4; // 500 is size of tile images
    ArrayList<Board> boards;
    Context ctx;

    //private int[] tilebmp = new int[16];
    ArrayList<Bitmap> tilebmp = new ArrayList<>();

    BoardGridAdapter(Context c) {
        ctx = c;
        /*tilebmp[0] = R.drawable.b_0;
        tilebmp[1] = R.drawable.b_1;
        tilebmp[2] = R.drawable.b_2;
        tilebmp[3] = R.drawable.b_3;
        tilebmp[4] = R.drawable.b_4;
        tilebmp[5] = R.drawable.b_5;
        tilebmp[6] = R.drawable.b_6;
        tilebmp[7] = R.drawable.b_7;
        tilebmp[8] = R.drawable.b_8;
        tilebmp[9] = R.drawable.b_9;
        tilebmp[10] = R.drawable.b_10;
        tilebmp[11] = R.drawable.b_11;
        tilebmp[12] = R.drawable.b_12;
        tilebmp[13] = R.drawable.b_13;
        tilebmp[14] = R.drawable.b_14;
        tilebmp[15] = R.drawable.b_15;*/
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inSampleSize = 16;
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_0, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_1, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_2, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_3, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_4, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_5, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_6, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_7, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_8, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_9, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_10, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_11, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_12, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_13, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_14, opts));
        tilebmp.add(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.b_15, opts));
    }

    void setBoards(ArrayList<Board> b) {
        boards = b;
    }

    public int getCount() {
        return boards.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }



    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iview;
        if (convertView == null) {
            iview = new ImageView(ctx);
            iview.setAdjustViewBounds(true);
            iview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            iview.setPadding(12,12,12,12);
        }
        else {
            iview = (ImageView) convertView;
        }

        Board b = boards.get(position);

        int width = tilebmp.get(0).getWidth();
        int height = tilebmp.get(0).getHeight();
        Bitmap grid = Bitmap.createBitmap(width*4, height*4, tilebmp.get(0).getConfig());

        Canvas canvas = new Canvas(grid);
        for(int i = 0; i < 16; i++) {
            int w = width * (i%4);
            int h = width * (i/4);
            canvas.drawBitmap(tilebmp.get(b.at(i)), w, h, null);
        }

        iview.setImageBitmap(grid);
        return iview;
    }
}
