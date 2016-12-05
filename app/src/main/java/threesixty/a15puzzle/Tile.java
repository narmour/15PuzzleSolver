package threesixty.a15puzzle;
public class Tile{
    int value;
    boolean blank;

    Tile(int v)
    {
        value = v;
        blank = (v == 0) ? true:false;
    }
    Tile(Tile t){
        this.value = t.value;
        this.blank = t.blank;
    }
}
