/**
 * Combinable.java
 * 
 * Christopher Hittner (c) 2015
 */
package entities;

/**
 * A Combinable object allows for objects that store a combinable count.
 *
 * @author Christopher Hittner
 */
public interface Combinable {
    
    /**
     * Adds another Combinable to this.
     * @param other The item being added to this.
     * @return Whether or not the combination occurred.
     */
    public boolean addOther(Combinable other);
    
    /**
     * Provides the size of this item.
     * @return The size of this.
     */
    public int getSize();
    
    /**
     * Increases the size by a given amount
     * 
     * @param amt The amount to increase the size by.
     * @condition amt >= 0
     */
    public void increaseSize(int amt);
    
    /**
     * Decreases the size by a given amount
     * 
     * @param amt The amount to increase the size by.
     * @return The amount that weren't added.
     * @condition amt >= 0
     */
    public int decreaseSize(int amt);
    
    /**
     * Removes all of the contents of this item.
     */
    public void removeAll();
    
}
