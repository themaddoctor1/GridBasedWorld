/**
 * Weapon.java
 * 
 * Christopher Hittner (c) 2015
 */
package items;

import entities.Creature;
import java.util.HashMap;

/**
 * A Weapon hurts things.
 *
 * @author Christopher Hittner
 */
public abstract class Weapon extends Item {
    
    public Weapon() { }
    
    @Override
    protected final void executeUse(HashMap<String, Object> params) {
        
        if(params.get("ATTACK") != null) try {
            Creature user = (Creature) params.get("USER");
            Creature targ = (Creature) params.get("ATTACK");
            
            attack(user, targ);
            
        } catch(Exception e) {
            throw new IllegalArgumentException("Parameter '" + params.get("ATTACK") + "' for ATTACK is invalid.");
        }
    }
    
    /**
     * Returns the accuracy of this weapon, which will be between 0 and 1, inclusive.
     * Basically, this returns the probability of an individual attack striking the target.
     * @return The accuracy; <% accuracy> / 100%
     */
    public abstract double accuracy();

    /**
     * Attacks the targeted Creature, if permitted.
     * @param user The Creature that is attacking.
     * @param targ The Creature that is being attacked.
     */
    protected abstract void attack(Creature user, Creature targ);
    
}
