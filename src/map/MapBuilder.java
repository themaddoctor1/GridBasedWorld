/**
 * MapBuilder.java
 * 
 * Christopher Hittner (c) 2016
 */
package map;

import map.templates.*;
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
     * @param bottomPerm The permeability of the first floor.
     * @condition height >= 1
     * @return A building with the desired height.
     */
    public static MapLocation[] buildSkyscraper(int height, boolean[][] bottomPerm) {
        //Error check.
        if(height <= 0)
            throw new IllegalArgumentException("Building height must be positive.");              
        
        
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
    
    
    /**
     * Creates a city block with varying height skyscrapers.
     * @param length The size on the y-axis, including the road on all sides.
     * @param minHeight The smallest allowed height.
     * @param maxHeight The largest allowed height.
     * @condition 0 < minHeight <= maxHeight.
     *            If this is not ensured, the numbers will be reversed.
     * @condition width > 2
     * @condition length > 2
     * @return A city block.
     */
    public static MapLocation[][][] buildCityBlock(int length, int minHeight, int maxHeight) {
        
        //Designates a width for the block. This will include the road.
        int width = 4;
        
        //Makes sure that maxHeight is greater than or equal to the minHeight.
        if(maxHeight < minHeight)
            return buildCityBlock(length, maxHeight, minHeight); //Recursive call with switched parameters.
        
        //The result: it is ensured that maxHeight > minHeight.
        
        if(length < 3)
            throw new IllegalArgumentException("Width and/or length must allow for buildings to exist.");
        else if(minHeight <= 0)
            throw new IllegalArgumentException("The buildings must have a height greater than zero.");
        
        //Creates the block, which will contain blank slots for now.
        MapLocation[][][] block = new MapLocation[width][length][];
        
        //Adds the buildings
        for(int x = 1; x < width-1; x++) for(int y = 1; y < length-1; y++) {
            
            //Calculates the height.
            int h = minHeight + (int)((1+maxHeight-minHeight)*Math.random());
            
            //Places a skyscraper in the slot.
            block[x][y] = buildSkyscraper(h, 
                    new boolean[][] {
                        new boolean[] {false, x==1, false},
                        new boolean[] {y==1, false, y==length-2},
                        new boolean[] {false, x==width-2, false}
                    }
            );
            
        }
        
        //Puts the streets in on the opposing x-sides.
        for(int i = 0; i < length; i++) {
            block[0][i] = new MapLocation[] {new StreetCell()};
            block[width-1][i] = new MapLocation[] {new StreetCell()};
        }
        
        //Puts the last of the road in.
        for(int i = 1; i < width-1; i++) {
            block[i][0] = new MapLocation[] {new StreetCell()};
            block[i][length-1] = new MapLocation[] {new StreetCell()};
        }
        
        //The result has been built, so return it.
        return block;
        
    }
    
}
