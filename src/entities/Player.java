/**
 * Player.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import map.MapLocation;

/**
 * A Player is a Singleton class that represents the player.
 *
 * @author Christopher Hittner
 */
public final class Player extends Creature {
    
    private static Player player = null;

    private Player(MapLocation loc) {
        super(loc);
    }

    @Override
    public void passTime(double t) { }
    
    /**
     * Gets the Player.
     * @return The player.
     */
    public static Player getPlayer() {
        //Gets the player, if one has been created.
        return (player == null)
                ? initPlayer()
                : player;
    }

    
    /**
     * Initializes a new Player.
     * @return The new Player.
     */
    public static Player initPlayer() {
        return player = new Player(null);
    }
    
}
