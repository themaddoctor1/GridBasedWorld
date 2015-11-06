/*
 * Cell.java
 *
 * Christopher Hittner (c) 2015
 */
package map;

/**
 * Represents a position within the game.
 * @author Christopher
 */
public abstract class Cell {
    
    /*
     * Order of indexes is ENWSUD (East-North-West-South-Up-Down)
     */
    protected boolean[][][] open = new boolean[3][3][3];
    
    /**
     * Creates a Cell that anything can enter.
     */
    public Cell() {
        for(int i = 0; i < 27; i++)
            open[i%3][(i/3)%3][i/9] = true;
    }
    
    /**
     * Creates a Cell that is open only in allowed directions relative to the Cell.
     * 
     * @condition The permittivity array must have 27 entries and be a 3x3x3 list.
     * @param isOpen The permittivity of the Cell in each of the 26 possible directions
     */
    public Cell(boolean[][][] isOpen) {
        open = isOpen;
    }
    
    
    /**
     * Sets whether or not something can travel in a particular direction.
     * @condition The parameter MUST have dimensions 3x3x3.
     * 
     * @param opened The settings for the openings.
     */
    protected void setOpenings(boolean[][][] opened) {
        open = opened;
    }
    
    /**
     * Returns the state of the openings for each of the 26 possible directions.
     * [1][1][1] is reserved for the Cell's position, and is therefore disregarded.
     * 
     * @return
     */
    public final boolean[][][] getOpenings() {
        return open.clone();
    }
    
    /**
     * Sets the opened/closed state of one of the 27 positions.
     * 
     * @condition  -1 <= x,y,z <= 1
     * @param x The x coordinate relative to the Cell.
     * @param y The y coordinate relative to the Cell.
     * @param z The z coordinate relative to the Cell.
     * @param opened Whether or not the opening should be permeable.
     */
    public final void setOpening(int x, int y, int z, boolean opened) {
        open[x+1][y+1][z+1] = opened;
    }
    
}
