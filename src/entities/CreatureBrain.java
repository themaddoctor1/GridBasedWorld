/**
 * CreatureBrain.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

/**
 * Runs processes for a Creature using the Delegation pattern, where 
 * a Creature is the listener because it is receiving the commands.
 *
 * @author Christopher Hittner
 */
public class CreatureBrain {
    private Creature delegator;
    
    /**
     * Sets a new observer.
     * @param c The new owner.
     */
    public final void setDelegator(Creature c) {
        delegator = c;
    }
    
    /**
     * Gets the current listener.
     * @return
     */
    public final Creature getDelegator() {
        return delegator;
    }
    
}
