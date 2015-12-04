/**
 * MapManager.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

import entities.Entity;

/**
 *
 * @author Christopher
 */
public class MapManager {
    private static Map map = null;
    
    private static EntityList entities = new EntityList();
    
    
    /**
     * Simulates the passage of a certain amount of time in seconds.
     * @param t 
     */
    public static void passTime(double t) {
        throw new UnsupportedOperationException("map.MapManager.passTime() has not been written yet.");
    }
    
    /**
     * Sets a new map to use.
     * @param m The Map to use.
     */
    public static void setMap(Map m) {
        map = m;
    }
    
    /**
     * Sets a new Map and Entity list to use.
     * @param m The new map.
     * @param e The new set of entities.
     */
    public static void setMap(Map m, EntityList e) {
        setMap(m);
        setEntityList(e);
    }
    
    /**
     * Sets the current Entity list to a new one.
     * @param e The new list.
     */
    public static void setEntityList(EntityList e) {
        entities = e;
    }
    
    
    /**
     * Gets the current Map.
     * @return The map.
     */
    public static Map getMap() {
        return map;
    }
    
    
    /**
     * Gets the current list of Entities.
     * @return The Entities.
     */
    public static EntityList getEntitiyList() {
        return entities;
    }
    
}
