abstract class Pieces {
    private boolean killed;

    public boolean isKilled() {
        return killed;
    }

    public abstract boolean canMove();
}