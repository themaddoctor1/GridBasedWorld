/**
 * Entity.java
 *
 * Christopher Hittner (c) 2015
 */
package entities;

import java.util.HashMap;
import map.Cell;

/**
 *
 * @author Christopher
 */
public abstract class Entity {
    private Cell location = null;
    
    private static long nextID = Long.MIN_VALUE;
    public final long ID;
    
    /**
     * Creates an Entity that has a position.
     * @param loc The initial location of the Entity.
     */
    public Entity(Cell loc) {
        location = loc;
        ID = nextID++;
    }
    
    /**
     * Simulates stuff for this Entity.
     * @param params 
     */
    public abstract void act(HashMap<String, Object> params);
    
    public final Cell getCell() {
        return location;
    }
    
    public void setCell(Cell loc) {
        location = loc;
    }
    
    /**
     * Simulates the passage of a period of time.
     * @param t The time to pass.
     */
    public abstract void passTime(double t);
    
}
