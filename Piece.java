abstract class Piece {
    private boolean killed;
    private Box box;

    public Piece(Box box) {
        this.box = box;
    }

    public boolean isKilled() {
        return killed;
    }

    

    public abstract boolean canMove();
}