/**
 * Item.java
 * 
 * Christopher Hittner (c) 2015
 */

package items;

import java.util.HashMap;
import map.Describable;

/**
 * An Item is an Object that can do things.
 *
 * @author Christopher Hittner
 */
public abstract class Item implements Describable {
    
    //Whether or not the Item is reusable.
    public final boolean REUSABLE;
    private boolean wasUsed;
    
    /**
     * Creates a reusable Item.
     */
    public Item() {
        this(true);
    }
    
    /**
     * Creates an Item.
     * @param reusable Whether or not the Item is reusable.
     */
    public Item(boolean reusable) {
        this.wasUsed = false;
        REUSABLE = reusable;
    }
    
    /**
     * Uses the Item.
     * @param params A set of objects used to help with using the Item.
     */
    public final void use(HashMap<String, Object> params) {
        if((REUSABLE || !wasUsed) && canUse(params)) {
            executeUse(params);
            wasUsed = true;
        }
    }
    
    /**
     * Determines whether or not the item is able to be used.
     * @param params The information given to the use() method.
     * @return Whether or not to permit use of the executeUse() method.
     */
    public abstract boolean canUse(HashMap<String, Object> params);
    
    /**
     * Uses the Item.
     * @param params Any information that may help with using the Item.
     */
    protected abstract void executeUse(HashMap<String, Object> params);
    
    /**
     * This method provides a description of the Item.
     * 
     * @return The description of this.
     */
    public abstract String DESCRIPTION();
    
    /**
     * This method provides the name of the Item, which must be written by any subclasses.
     * 
     * @return The name of the Item.
     */
    public abstract String NAME();
    
    
}
