/**
 * CreatureBrain.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import java.util.HashMap;

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
    protected abstract void move(int x, int y, int z);
    
    
    /**
     * Attacks a Creature.
     * @param target The target of the attack.
     */
    protected abstract void attack(Creature target);
    
}
