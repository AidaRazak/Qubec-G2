package model;

public class Plus extends Piece{
    public Plus(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove() {
        // Implement Plus-specific movement rules
        // Move horizontally or vertically any distance, cannot skip over other pieces.
        return true;
    }
}
