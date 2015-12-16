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
     * BuildingCellType is used to simplify identification of building types.
     */
    public static enum BuildingCellType {
        BOTTOM, TOP, NO_VERTICAL, FULL_VERTICAL
    }
    
    
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
    
    /**
     * Creates a custom BuildingCell layout.
     * 
     * @param type The type of BuildingCell.
     * @param permittivity The permittivity on the current level.
     */
    public BuildingCell(BuildingCellType type, boolean[][] permittivity) {
        
        this();
        
        for(int i = 0; i < 9; i++)
            setOpening((i%3)-1, (i/3)-1, 0, permittivity[i%3][i/3]);
        
        switch (type) {
            //Bottom floor should not have a bottom opening.
            case BOTTOM:
                setOpening(0, 0, -1, false);
                break;
            //One can't simply go up when there is nothing above...
            case TOP:
                setOpening(0, 0, 1, false);
                break;
            case NO_VERTICAL:
                setOpening(0, 0, -1, false);
                setOpening(0, 0, 1, false);
                break;
            case FULL_VERTICAL:
                setOpening(0, 0, -1, true);
                setOpening(0, 0, 1, true);
                
                
        }
        
        
    }
    
    @Override
    public String getDescription(int quality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
