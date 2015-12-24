/**
 * ZombieBrain.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import java.util.HashMap;

/**
 * ZombieBrain is an AI module meant for ZombieHorde objects.
 *
 * @author Christopher Hittner
 */
public class ZombieBrain extends CreatureBrain {
    
    //This variable holds the distance from the player. Zombies will attack if and
    //only if they are at a distance of zero or less from the player.
    private double timeToTarget = 25;
    
    @Override
    public void act(HashMap<String, Object> params) {
        
        //Finds out how much time has passed
        double timePassed = (double) params.get("TIME");
        
        //Moves closer for the attack if necessary
        timeToTarget = getCreature().getLocation().equals(Player.getPlayer().getLocation())
                ? timeToTarget - timeToTarget
                : 25;
        
        //If an attack is possible, strike with the fury of a thousand suns.
        if(timeToTarget <= 0)
            attack(Player.getPlayer());
        
    }

    @Override
    protected void attack(Creature target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double timeToTarget() {
        return timeToTarget;
    }
    
}
