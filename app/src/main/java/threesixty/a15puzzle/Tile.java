package threesixty.a15puzzle;
public class Tile{
    int value;
    int imgResource;

    Tile(int v,int img)
    {
        value = v;
        imgResource = img;
    }
    Tile(Tile t){
        this.value = t.value;
        this.imgResource = t.imgResource;
    }
}
