package chesspieces;

public class Hourglass extends Piece {

    public Hourglass(int xPos, int yPos, boolean white) {
        super(yPos, yPos, white);
    }

    @Override
    // can moves in a 3x2 L shape in any orientation  (kind of like the knight in standard 
    // chess.) This is the only piece that can skip over other pieces.
    public boolean canMove() {
        return true;
    }

    @Override
    public void move(int xPos, int yPos) {

    }
    
}
