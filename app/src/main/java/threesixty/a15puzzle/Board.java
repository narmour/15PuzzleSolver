package threesixty.a15puzzle;
import java.util.*;
public class Board{
    ArrayList<Tile> brd;
    Board(){
        brd = new ArrayList<>();
        for(int i = 1; i <= 16; i++)
            brd.add(new Tile(i-1));
    }
    void printBoard(){
        for(int i = 0; i < brd.size(); i++){
            if(i % 4 == 0 && i != 0)
                System.out.println();
            System.out.print(brd.get(i).value + " ");
        }
        System.out.println();
    }

    ArrayList<Tile>  move(int i, int j){
        ArrayList<Tile> brdCpy = new ArrayList<>(); 
        for(int k = 0; k < brd.size(); k++){
            brdCpy.add(new Tile(this.brd.get(k)));
        }
        Collections.swap(brdCpy, i , j);
        return brdCpy;
    }

    ArrayList<Integer> validMoves(){
        ArrayList<Integer> moves = new ArrayList<>();
        for(int i = 0; i < this.brd.size(); i++){
            if(brd.get(i).blank){
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

    void printMoves(){
        System.out.println("Valid Moves");
        for(int i = 0; i < validMoves().size();i++)
            System.out.print(validMoves().get(i)+ " ");
        System.out.println();
    }
        
    public static void main(String[] args){
        Board b = new Board();
        b.printBoard();
        b.printMoves();
        System.out.println();
        b.brd = b.move(0,1);
        b.printBoard();
        b.printMoves();
    }
        
}
