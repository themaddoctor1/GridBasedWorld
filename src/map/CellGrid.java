/*
 * MapGrid.java
 *
 * Christopher Hittner (c) 2015
 */
package map;

import java.util.Arrays;

/**
 * Represents a set of map positions within the game.
 * @author Christopher
 */
public abstract class CellGrid {
    /*   x  y  z */
    Cell[ ][ ][ ] cells;
    
    /**
     * Creates a CellGrid of specified dimensions.
     * @param x The length (E-W)
     * @param y The width (N-S)
     * @param z The height (U-D)
     */
    public CellGrid(int x, int y, int z) {
        cells = new Cell[x][y][z];
    }
    
    /**
     * Creates a CellGrid based on an already existing layout.
     * @param grid An array of Cells.
     */
    public CellGrid(Cell[][][] grid) {
        cells = grid;
    }
    
    /**
     * Creates a CellGrid that is a duplicate of the original.
     * The constructor does NOT clone the objects, so the copy will
     * have the same pointers.
     * 
     * @param other The other CellGrid.
     */
    public CellGrid(CellGrid other) {
        this(other.cells);
    }
    
    /**
     * Returns the cell at a position relative to the provided cell.
     * @param c The cell to look at
     * @param x The relative position on x.
     * @param y The relative position on y.
     * @param z The relative position on z.
     * @return The cell at a distance of <x, y, z> from the given Cell.
     */
    public Cell getCellRelative(Cell c, int x, int y, int z) {
        //Gets the position of C and stores it.
        int[] posC = getPosition(c);
        
        //Returns the Cell at the given distance relative to the
        //Cell provided to the method.
        return getCell(posC[0]+x, posC[1]+y, posC[2]+z);
    }
    
    /*
     * Returns the Cell at a given position.
     * @param x The x coordinate
     * @param y The y coordinate
     * @param z The z coordinate
     * @return The cell at (x, y, z).
     */
    public Cell getCell(int x, int y, int z) {
        try { return cells[x][y][z]; }
        catch(Exception e) { return null; }
    }
    
    /**
     * Gets the location of a cell.
     * @param c The cell that the location is needed for.
     * @return The coordinate of the cell, or null if it can't be found.
     */
    public int[] getPosition(Cell c) {
        for(int x = 0; x < cells.length; x++)
            for(int y = 0; y < cells[x].length; y++)
                for(int z = 0; z < cells[x][y].length; y++) {
                    if(c.equals(cells[x][y][z]))
                        return new int[] {x, y, z};
                }
        
        return null;
    }
    
    /**
     * Places a Cell at the selected coordinate.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     * @param c The Cell to insert.
     * @return The Cell that used to be stored at that position, or null.
     */
    public Cell setPosition(int x, int y, int z, Cell c) {
        if(x < 0) {
            //Cell is out of bounds on x, so create a Western layer and resursively call
            //for the insertion.
            addLayerWest();
            return setPosition(x+1, y, z, c);
        } else if(x >= sizeX()) {
            //Cell is out of bounds on x, so create an Eastern layer and recursively call for the insertion.
            addLayerEast();
            return setPosition(x, y, z, c);
        } else if(y < 0) {
            //Cell is out of bounds on y, so create a Southern layer and resursively call
            //for the insertion.
            addLayerSouth();
            return setPosition(x+1, y, z, c);
        } else if(y >= sizeY()) {
            //Cell is out of bounds on x, so create an Eastern layer and recursively call for the insertion.
            addLayerNorth();
            return setPosition(x, y, z, c);
        } else if(z < 0) {
            //Underground Cells are not supported; throw an error.
            throw new IllegalArgumentException("The position's z value of " + z + " can't be negative!");
        } else if(z >= sizeZ()) {
            //Cell is out of bounds on z, so create a top layer and recursively call for the insertion.
            addLayerAbove();
            return setPosition(x, y, z, c);
        }
        
        //Grabs a reference to the replaced Cell prior to removal.
        Cell removed = getCell(x, y, z);
        
        //Replaces the old Cell with the new one.
        cells[x][y][z] = c;
        
        return removed;
        
    }
    
    /**
     * Gets the size on the x-axis
     * @return The size of the x-axis
     */
    public int sizeX() {
        return cells.length;
    } 
    
    
    /**
     * Gets the size on the y-axis
     * @return The size of the y-axis
     */
    public int sizeY() {
        
        //Holds the largest value found
        int max = 0;
        
        for(int x = 0; x < cells.length; x++) {
            max = Math.max(max, cells[x].length);
        }
        
        return max;
    }
    
    
    /**
     * Gets the size on the z-axis
     * @return The size of the z-axis
     */
    public int sizeZ() {
        
        //Holds the largest value found
        int max = 0;
        
        for(int x = 0; x < cells.length; x++) for(int y = 0; y < cells[x].length; x++) {
            max = Math.max(max, cells[x][y].length);
        }
        
        return max;
    }
    
    /**
     * Adds another layer to the top CellGrid.
     */
    public void addLayerAbove() {
        for(int x = 0; x < cells.length; x++)
            for(int y = 0; y < cells[x].length; y++) {
                cells[x][y] = Arrays.copyOf(cells[x][y], cells[x][y].length + 1);
            }
    }
    
    /*
     * Adds a layer on the North side (+y)
     */
    public void addLayerNorth() {
        for(int x = 0; x < cells.length; x++) {
            cells[x] = Arrays.copyOf(cells[x], cells[x].length + 1);
            cells[x][sizeY()-1] = new Cell[sizeZ()];
        }
            
    }
    
    /*
     * Adds a layer on the North side (-y)
     */
    public void addLayerSouth() {
        for(int x = 0; x < cells.length; x++) {
            //Copies this slice on x
            Cell[][] copy = cells[x];
            //Makes the list one longer.
            cells[x] = new Cell[sizeY()+1][sizeZ()];
            //Puts a value on the South end.
            cells[x][0] = new Cell[sizeZ()];
            
            //Reinserts the values.
            for(int i = 0; i < copy.length; i++)
                cells[x][i+1] = copy[i];
            
        }
            
    }
    
    /**
     * Adds a layer on the East side
     */
    public void addLayerEast() {
        
        //Increases the length by one.
        cells = Arrays.copyOf(cells, cells.length+1);
        
        //Inserts uninstantiated array equal to the max sizes of the map.
        cells[cells.length-1] = new Cell[sizeY()][sizeZ()];
            
    }
    
    /**
     * Adds a layer on the East side
     */
    public void addLayerWest() {
        
        //Copies the map.
        Cell[][][] copy = cells;
        
        //Increases the length by one.
        cells = new Cell[sizeX()+1][sizeY()][sizeZ()];
        
        //Inserts uninstantiated array equal to the max sizes of the map.
        cells[0] = new Cell[sizeY()][sizeZ()];
        
        //Reinserts the original values
        for(int i = 0; i < copy.length; i++)
            cells[i+1] = copy[i];
            
    }
    
    
}
