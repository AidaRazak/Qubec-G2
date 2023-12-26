package chesspieces;

public class Time extends Piece{

    public Time(int xPos, int yPos, boolean white) {
        super(yPos, yPos, white);
    }

    @Override
    // can only move diagonally but can go any distance. It cannot skip over other pieces.
    public boolean canMove() {

        return true;
    }

    @Override
    public void move(int xPos, int yPos) {

    }
    
}
