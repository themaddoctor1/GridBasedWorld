/**
 * Street.java
 *
 * Christopher Hittner (c) 2015
 */
package map.templates;

import map.MapLocation;

/**
 * Represents a Street, which will allow movement in any direction.
 * 
 * @author Christopher Hittner
 */
public class Street extends MapLocation {
    
    /**
     * Creates a Street where movement is allowed in all eight directions.
     */
    public Street() {
        //Initially permits maximum permittivity
        super();
        
        //Makes the Cell only allow permutation on the same z-axis
        for(int i = 0; i < 9; i++) {
            //One layer below
            getOpenings()[i%3][i/3][0] = false;
            
            //One layer above
            getOpenings()[i%3][i/3][2] = false;
        }
    }
    
    /**
     * Creates a Street with a predetermined permittivity.
     * @param XY_permittivity The permittivity on the XY plane.
     */
    public Street(boolean[][] XY_permittivity) {
        //Makes sure that only the Z-coordinate of this item can be accessed
        this();
        
        //Places each element in the correct position on the object's Z coordinate.
        for(int i = 0; i < 9; i++)
            getOpenings()[i%3][i/3][1] = XY_permittivity[i%3][i/3];
    }

    @Override
    public String getDescription(int quality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
