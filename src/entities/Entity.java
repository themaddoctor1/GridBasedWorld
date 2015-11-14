/**
 * Entity.java
 *
 * Christopher Hittner (c) 2015
 */
package entities;

import map.Cell;

/**
 *
 * @author Christopher
 */
public abstract class Entity {
    private Cell location = null;
    
    /**
     * Creates an Entity that has a position.
     * @param loc The initial location of the Entity.
     */
    public Entity(Cell loc) {
        location = loc;
    }
    
    /**
     * Simulates stuff for this Entity.
     * @param params 
     */
    public abstract void act(Object... params);
    
    public final Cell getCell() {
        return location;
    }
    
}
