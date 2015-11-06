/**
 * Creature.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import map.Cell;
import map.MapLocation;

/**
 * Creature is the basis for all of the living enemies and the player within
 * the game. It utilizes the Delegation Pattern to allow for the program to
 * function properly and to enable modularity with CreatureBrains.
 *
 * @author Christopher Hittner
 */
public class Creature extends Entity {
    
    CreatureBrain brain = null;
    
    /**
     * Creates a Creature (has no brain by default).
     * @param loc The current location.
     */
    public Creature(MapLocation loc) {
        super(loc);
    }
    
    /**
     * Sets a new brain.
     * @param cb The brain.
     */
    public final void setObserver(CreatureBrain cb) {
        brain = cb;
        cb.setDelegator(this);
    }
    
    /**
     * Gets the current CreatureBrain and returns it.
     * @return The delegate.
     */
    public final CreatureBrain getObserver() {
        return brain;
    }
    
}
