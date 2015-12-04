/**
 * Creature.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import items.Inventory;
import items.Loadout;
import java.util.HashMap;
import map.Cell;
import map.MapLocation;

/**
 * Creature is the basis for all of the living enemies and the player within
 * the game. It utilizes the Delegation Pattern to allow for the program to
 * function properly and to enable modularity with CreatureBrains.
 *
 * @author Christopher Hittner
 */
public abstract class Creature extends Entity {
    
    protected CreatureBrain brain = null;
    protected Loadout inventory = new Loadout();
    
    
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
    public final void setBrain(CreatureBrain cb) {
        brain = cb;
        cb.setCreature(this);
    }
    
    /**
     * Gets the current CreatureBrain and returns it.
     * @return The delegate.
     */
    public final CreatureBrain getBrain() {
        return brain;
    }
    
    
    @Override
    public void act(HashMap<String, Object> params) {
        if(brain != null)
            brain.act(params);
    }
    
    
    public MapLocation getLocation() {
        return (MapLocation) this.getCell();
    }
    
    
    public void setLocation(MapLocation loc) {
       this.setCell(loc);
    }
    
}
