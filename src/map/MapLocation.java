/**
 * MapLocation.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

/**
 *
 * @author Christopher
 */
public abstract class MapLocation extends Cell implements Describable {
    
    public MapLocation() { super(); }
    public MapLocation(boolean[][][] open) {
        super(open);
    }
    
}
