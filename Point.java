class Point extends Piece {
    public Point(Box box) {
        super(box);
    }

    private boolean forward = true;

    @Override
    public boolean canMove() {
        // Implement Point-specific movement rules
        // Move forward 1 or 2 steps, turn around when reaching the end, cannot skip over other pieces.
        return true;
    }
}