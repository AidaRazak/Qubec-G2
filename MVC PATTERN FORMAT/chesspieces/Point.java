package chesspieces;

public class Point extends Piece {

    public Point(int xPos, int yPos, boolean white) {
        super(yPos, yPos, white);
    }

    @Override
    // can only move forward, 1 or 2 steps. If it reaches the end of the board, it turns 
    // around and starts heading back the other way. It cannot skip over other pieces.
    public boolean canMove() {
        return true;
    }

    @Override
    public void move(int xPos, int yPos) {

    }
    
}
