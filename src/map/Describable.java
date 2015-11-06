/**
 * Describable.java
 * 
 * Christopher Hittner (c) 2015
 */
package map;

/**
 * Allows an Object to be described.
 * 
 * @author Christopher Hittner
 */
public interface Describable {
    
    /**
     * Provides a description of an item based on what it "looks like".
     * 
     * @param quality The quality of the information.
     * @return A description of the item.
     */
    public String getDescription(int quality);
}
