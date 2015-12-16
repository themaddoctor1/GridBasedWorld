/**
 * MapBuilder.java
 * 
 * Christopher Hittner (c) 2016
 */
package map;

import map.templates.BuildingCell;
import map.templates.BuildingCell.BuildingCellType;

/**
 * MapBuilder is a static class that is used to generate maps and substructures.
 *
 * @author Christopher Hittner
 */
public class MapBuilder {
    
    /**
     * Creates a building of a designated height.
     * @param height The height of the building
     * @condition height >= 1
     * @return A building with the desired height.
     */
    public static MapLocation[] buildSkyscraper(int height) {
        //Error check.
        if(height <= 0)
            throw new RuntimeException("Building height must be positive.");
        
        //Holds the permeability of the bottom floor horizontally.
        boolean[][] bottomPerm = new boolean[][]{
                            new boolean[]{true, true, true},    
                            new boolean[]{true, true, true},
                            new boolean[]{true, true, true}                    
        };
        
        //Holds the permeability of the rest of the building.
        boolean[][] buildingPerm = new boolean[][]{
                            new boolean[]{false, false, false},    
                            new boolean[]{false, false, false},
                            new boolean[]{false, false, false}                    
        };
        
        //Special case: one floor building
        if(height == 1)
            return new MapLocation[] {
                new BuildingCell(BuildingCellType.NO_VERTICAL, bottomPerm)
            };
        
        //Creates storage for the building's Cells.
        MapLocation[] tower = new MapLocation[height];
        
        //Places the bottom onto the building.
        tower[0] = new BuildingCell(BuildingCellType.BOTTOM, bottomPerm);
        
        //Puts the pieces in between the top and bottom together.
        for(int i = 1; i < height-1; i++) {
            tower[i] = new BuildingCell(BuildingCellType.FULL_VERTICAL, buildingPerm);
        }
        
        //Puts the top of the building on.
        tower[height-1] = new BuildingCell(BuildingCellType.TOP, buildingPerm);
        
        //Returns the result
        return tower;
    }
    
}
