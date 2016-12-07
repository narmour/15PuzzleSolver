package threesixty.a15puzzle;

/**
 * Created by student on 12/7/16.
 */

public class State {
    //We define a state of the game to be the board position,
    // the number of moves made to reach the board position, and the previous state.
    Board brdPosition;
    int numMoves;
    State prevState;

    // constructor takes in board position, num moves, prev state
    State(Board b,int n,State p){
        brdPosition = b;
        numMoves = n;
        prevState = p;
    }


}
