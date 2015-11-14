/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

/**
 *
 * @author Christopher
 */
public class Map extends CellGrid {
    
    public Map(int x, int y, int z) {
        super(x, y, z);
    }
    
    public Map(MapLocation[][][] grid) {
        super(grid);
    }
    
    public Map(Map other) {
        super(other);
    }
    
    
    
}
