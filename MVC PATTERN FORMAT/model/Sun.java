package model;

public class Sun extends Piece {

    public Sun(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove() {

        return true;
    }
    
}
