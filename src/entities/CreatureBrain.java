/**
 * CreatureBrain.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import java.util.HashMap;
import map.MapLocation;
import map.MapManager;

/**
 * Runs processes for a Creature using the Delegation pattern, where 
 * a Creature is the listener because it is receiving the commands.
 *
 * @author Christopher Hittner
 */
public abstract class CreatureBrain {
    private Creature delegator;
    
    /**
     * Sets a new CreatureBrain to delegate.
     * @param c The new delegator.
     */
    public final void setCreature(Creature c) {
        delegator = c;
    }
    
    /**
     * Gets the current Creature that this CreatureBrain is assisting..
     * @return The delegator.
     */
    public final Creature getCreature() {
        return delegator;
    }
    
    /**
     * Performs necessary actions.
     * @param params What the CreatureBrain is given to work with.
     */
    public abstract void act(HashMap<String, Object> params);
    
    /**
     * Moves the Creature in a given direction if allowed.
     * @param x The x-value, whare |x| <= 1.
     * @param y The y-value, where |y| <= 1.
     * @param z The z-value, where |z| <= 1.
     */
    protected void move(int x, int y, int z) {
        //Grabs the start and end positions.
        MapLocation loc = getCreature().getLocation();
        MapLocation dst = (MapLocation) MapManager.getMap().getCellRelative(loc, x, y, z);
        
        //The movement has to be approved by the origin and the destination.
        if(loc.getOpenings()[x][y][z] && dst.getOpenings()[2-x][2-y][2-z]) {
            getCreature().setCell(MapManager.getMap().getCellRelative(loc, x, y, z));
        }
        
    }
    
    
    /**
     * Attacks a Creature.
     * @param target The target of the attack.
     */
    protected abstract void attack(Creature target);
    
}
