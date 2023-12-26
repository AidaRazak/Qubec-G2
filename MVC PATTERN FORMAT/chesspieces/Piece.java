package chesspieces;

public abstract class Piece {
    private int xPos;
    private int yPos;
    private boolean killed;
    public boolean white;

    public Piece(int xPos, int yPos, boolean white) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.setWhite(white);
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int newXPos) {
        this.xPos = newXPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int newYPos) {
        this.xPos = newYPos;
    }

    public boolean isWhite() 
    { 
        return this.white; 
    } 
  
    public void setWhite(boolean white) 
    { 
        this.white = white; 
    } 
  
    public boolean isKilled() 
    { 
        return this.killed; 
    } 
  
    public void setKilled(boolean killed) 
    { 
        this.killed = killed; 
    }

    public abstract boolean canMove();
    
    public abstract void move (int xPos, int yPos);
}