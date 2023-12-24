class Hourglass extends Piece {
    public Hourglass(Box box) {
        super(box);
    }

    @Override
    public boolean canMove() {
        // Implement Hourglass-specific movement rules
        // Move in a 3x2 L shape in any orientation, can skip over other pieces.
        return true;
    }
}