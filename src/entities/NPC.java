/**
 * NPC.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

import java.util.HashMap;
import map.MapLocation;

/**
 * An NPC is an Entity that cannot be controlled directly by the player.
 *
 * @author Christopher Hittner
 */
public class NPC extends Creature {
    
    public NPC(MapLocation loc) {
        super(loc);
    }
    
    @Override
    public void passTime(double t) {
        
        HashMap<String, Object> params = new HashMap<>();
        params.put("TIME", t);
        
        this.act(params);
    }
    
}
