/**
 * Map.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

/**
 * A Map is a type of CellGrid that uses MapLocations instead of Cells.
 *
 * @author Christopher Hittner
 */
public class Map extends CellGrid {
    
    /**
     * Creates a Map of specified dimensions.
     * @param x Size on x-axis
     * @param y Size on y-axis
     * @param z Size on z-axis
     */
    public Map(int x, int y, int z) {
        super(x, y, z);
    }
    
    /**
     * Creates a Map based of a series of locations.
     * @param grid The set of locations.
     */
    public Map(MapLocation[][][] grid) {
        super(grid);
    }
    
    /**
     * Creates a Map based on another Map.
     * @param other The other Map.
     */
    public Map(Map other) {
        super(other);
    }
    
    
}
