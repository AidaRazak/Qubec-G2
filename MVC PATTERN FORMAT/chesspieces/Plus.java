package chesspieces;

public class Plus extends Piece{
    public Plus(int xPos, int yPos, boolean white) {
        super(yPos, yPos, white);
    }

    @Override
    // can move horizontally and vertically only but can go any distance. It cannot skip over 
    // other pieces.
    public boolean canMove() {
        // Implement Plus-specific movement rules
        // Move horizontally or vertically any distance, cannot skip over other pieces.
        return true;
    }

    @Override
    public void move(int xPos, int yPos) {

    }
}
