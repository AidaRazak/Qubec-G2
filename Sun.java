class Sun extends Piece {
    public Sun(Box box) {
        super(box);
    }

    @Override
    public boolean canMove() {
        // Implement Sun-specific movement rules
        // Move one step in any direction.
        return true;
    }
}
