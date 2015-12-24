/**
 * InaccessibleCell.java
 * 
 * Christopher Hittner (c) 2015
 */
package map.templates;

import java.awt.Image;
import map.MapLocation;

/**
 * A MapLocation that does not allow anything to go through it.
 * 
 * @author Christopher Hittner
 */
public final class InaccessibleCell extends MapLocation {
    
    /**
     * Instantiates the MapLocation.
     */
    public InaccessibleCell() {
        super();
        
        //Closes all of the openings
        for(int i = 0; i < 27; i++)
            setOpening((i%3)-1, (i/3)%3 - 1, (i/9) - 1, false);
        
    }

    @Override
    public String getDescription(int quality) {
        return "There is nothing but darkness.";
    }

    @Override
    public Image getPicture() {
        return null;
    }
    
}
