/**
 * Street.java
 *
 * Christopher Hittner (c) 2015
 */
package map.templates;

import java.awt.Image;
import map.MapLocation;

/**
 * Represents a Street, which will allow movement in any direction.
 * 
 * @author Christopher Hittner
 */
public class StreetCell extends MapLocation {
    
    /**
     * Creates a Street where movement is allowed in all eight directions.
     */
    public StreetCell() {
        //Initially permits maximum permittivity
        super();
        
        //Makes the Cell only allow permutation on the same z-axis
        for(int i = 0; i < 9; i++) {
            //One layer below
            getOpenings()[i%3][i/3][0] = false;
            
            //One layer above
            getOpenings()[i%3][i/3][2] = false;
        }
        
        //Limits movement to strictly NESW.
        for(int i = 0; i < 4; i++)
            getOpenings()[(i%2)*2][(i/2)*2][1] = false;
        
    }
    
    /**
     * Creates a Street with a predetermined permittivity.
     * @param XY_permittivity The permittivity on the XY plane.
     */
    public StreetCell(boolean[][] XY_permittivity) {
        //Makes sure that only the Z-coordinate of this item can be accessed
        this();
        
        //Places each element in the correct position on the object's Z coordinate.
        for(int i = 0; i < 9; i++)
            getOpenings()[i%3][i/3][1] = XY_permittivity[i%3][i/3];
    }

    @Override
    public String getDescription(int quality) {
        throw new UnsupportedOperationException("map.templates.StreetCell.getDescription() has not been written yet.");
    }

    @Override
    public Image getPicture() {
        throw new UnsupportedOperationException("map.templates.StreetCell.getPicture() has not been written yet.");
    }
    
}
