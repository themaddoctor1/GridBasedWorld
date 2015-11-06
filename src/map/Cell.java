/*
 * Cell.java
 *
 * Christopher Hittner (c) 2015
 */
package map;

import map.cellcontent.CellContentManager;

/**
 * Represents a position within the game.
 * @author Christopher
 */
public abstract class Cell {
    
    /*
     * Order of indexes is ENWSUD (East-North-West-South-Up-Down)
     */
    protected boolean[][][] open = new boolean[3][3][3];
    
    //Manages the contents of this Cell.
    protected CellContentManager contents = null;
    
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
    public boolean[][][] getOpenings() {
        return open.clone();
    }
    
    /**
     * Gets the current CellContentManager for this Cell.
     * @return The CellContentManager.
     */
    public CellContentManager getContentManager() {
        return contents;
    }
    /**
     * Sets a new CellContentManager for this Cell.
     * @param manager The new CellContentManager.
     */
    public void setContentManager(CellContentManager manager) {
        contents = manager;
    }
    
}
