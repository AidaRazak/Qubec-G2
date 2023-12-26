package chesspieces;

public class Sun extends Piece {

    public Sun(int xPos, int yPos, boolean white) {
        super(yPos, yPos, white);
    }

    @Override
    // can move only one step in any direction. The game ends when the Sun is captured by 
    // the other side. 
    public boolean canMove() {
        return true;
    }

    @Override
    public void move(int xPos, int yPos) {

    }
    
}
