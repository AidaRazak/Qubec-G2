class Time extends Pieces {
    @Override
    public boolean canMove() {
        // Implement Time-specific movement rules
        // Move diagonally any distance, cannot skip over other pieces.
        return true;
    }
}