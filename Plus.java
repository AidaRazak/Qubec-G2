class Plus extends Pieces {
    @Override
    public boolean canMove() {
        // Implement Plus-specific movement rules
        // Move horizontally or vertically any distance, cannot skip over other pieces.
        return true;
    }
}