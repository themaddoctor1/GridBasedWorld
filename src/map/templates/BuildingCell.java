/**
 * BuildingCell.java
 * 
 * Christopher Hittner (c) 2015
 */
package map.templates;

import map.MapLocation;

/**
 * Describes a standard piece of a building.
 * 
 * @author Christopher Hittner
 */
public class BuildingCell extends MapLocation {

    /**
     * Creates a BuildingCell that only allows vertical motion.
     */
    public BuildingCell() {
        super();
        
        //Only the center shaft should be permeable.
        for(int i = 0; i < 27; i++) {
            getOpenings()[i%3][(i/3)%3][i/9] = (i%3 == (i/3)%3 && i%3 == 1);
        }
        
    }
    
    /**
     * Creates a BuildingCell with custom permittivity settings.
     * 
     * @condition permittivity must be a 3x3x3 array.
     * @param permittivity
     */
    public BuildingCell(boolean[][][] permittivity) {
        super(permittivity);
    }
    
    @Override
    public String getDescription(int quality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
