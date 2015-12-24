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
    
    public static MapLocation[][][] buildBuilding(int width, int length, int height, boolean[][] bottomPerm) {
        
        //Holds the building
        MapLocation[][][] building = new MapLocation[width][length][height];
        
        //Error check
        if(width < 1 || length < 1 || height < 1)
            throw new IllegalArgumentException("Request for building with dimensions "
                    + width + " by " + length + " by " + height + " is not permitted.");
        
        for(int x = 0; x < width; x++)
            for(int y = 0; y < length; y++)
                for(int z = 0; z < height; z++) {
                    //Creates the cell and inserts it. Buildings should not allow exit
                    //out of windows except on the first floor.
                    BuildingCell cell = new BuildingCell(new boolean[][][] {
                                new boolean[][]{
                                    new boolean[] {false, (z==0 && bottomPerm[0][0])||(x>0&&y>0), false},
                                    new boolean[] {false, (z==0 && bottomPerm[0][1])||x>0, false},
                                    new boolean[] {false, (z==0 && bottomPerm[0][2])||(x>0&&y<length-1), false}
                                },
                                new boolean[][]{
                                    new boolean[] {false, (z==0 && bottomPerm[1][0])||y > 0, false},
                                    new boolean[] {z > 0, false, z < height-1},
                                    new boolean[] {false, (z==0 && bottomPerm[1][2]) || y < length-1, false}
                                },
                                new boolean[][]{
                                    new boolean[] {false, (z==0 && bottomPerm[2][0])||(x<width&&y>0), false},
                                    new boolean[] {false, (z==0 && bottomPerm[2][1])||x<width-1, false},
                                    new boolean[] {false, (z==0 && bottomPerm[2][2])||(x<width-1&&y>0), false}
                                }
                    });
                    building[x][y][z] = cell;
                    
                }
        
        return building;
        
    }
    
    
    /**
     * Creates a city block with varying height skyscrapers.
     * @param width The size of buildings on the x-axis.
     * @param length The size of buildings on the y-axis.
     * @param buildingsPerBlock The number of buildings long the road should be.
     * @param minHeight The smallest allowed height.
     * @param maxHeight The largest allowed height.
     * @param orientation The alignment of the block. true is horizontal, and false is vertical.
     * @condition 0 < minHeight <= maxHeight.
     *            If this is not ensured, the numbers will be reversed.
     * @condition width > 2
     * @condition length > 2
     * @return A city block.
     */
    public static MapLocation[][][] buildCityBlock(int width, int length, int buildingsPerBlock, int minHeight, int maxHeight, boolean orientation) {
        
        //Designates a width for the block. This will include the road.
        
        //Makes sure that maxHeight is greater than or equal to the minHeight.
        if(maxHeight < minHeight)
            return buildCityBlock(width, length, buildingsPerBlock, maxHeight, minHeight, orientation); //Recursive call with switched parameters.
        
        //The result: it is ensured that maxHeight > minHeight.
        
        if(length < 1 || width < 1)
            throw new IllegalArgumentException("Width and/or length must allow for buildings to exist.");
        else if(minHeight < 1)
            throw new IllegalArgumentException("The buildings must have a height greater than zero.");
        
        //Creates the block, which will contain blank slots for now.
        MapLocation[][][] block = new MapLocation[2 + buildingsPerBlock * width][2*length+2][maxHeight];
        
        //Number of buildings on x-axis.
        int buildingsX = orientation ? 2 : buildingsPerBlock;
        
        //Number of buildings on the y-axis
        int buildingsY = buildingsPerBlock + 2 - buildingsX;
        
        //Creates and adds every building.
        for(int x = 0; x < buildingsX; x++) {
            for(int y = 1; y < buildingsY; y++) {
                
                //Calculates a building height.
                int buildingHeight = (int)(minHeight + (1+maxHeight-minHeight)*Math.random());
                
                //Creates the building.
                MapLocation[][][] building = buildBuilding(width, length, buildingHeight
                        , new boolean[][]{
                            new boolean[] {false, x==0, false},
                            new boolean[] {y==0, true, y==buildingsY-1},
                            new boolean[] {false, x==buildingsX-1, false}
                });
                
                //Adds every cell to the block.
                for(int i = 0; i < width; i++) for(int j = 0; j < length; j++) for(int k = 0; k < buildingHeight; k++) {
                    block[1+width*x+i][1+length*y+j][k] = building[i][j][k];
                }
                
            }
        }
        
        //Puts the streets in on the opposing x-sides.
        for(int i = 0; i < 2+buildingsY*length; i++) {
            block[0][i] = new MapLocation[] {new StreetCell()};
            block[2+buildingsX*width+1][i] = new MapLocation[] {new StreetCell()};
        }
        
        //Puts the last of the road in.
        for(int i = 1; i < 2+buildingsX*width+1; i++) {
            block[i][0] = new MapLocation[] {new StreetCell()};
            block[i][2+buildingsY*width+1] = new MapLocation[] {new StreetCell()};
        }
        
        //The result has been built, so return it.
        return block;
        
    }
    
}
